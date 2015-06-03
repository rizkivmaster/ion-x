package org.ion.client.api.v1.implementation;

import org.ion.client.services.UserPreferenceService;
import org.ionexchange.v1.objects.ApproveP2PTransactionSpec;
import org.ion.client.api.v1.IONAPIBase;
import org.ionexchange.v1.objects.IncomingTransactionData;
import org.ionexchange.v1.objects.OpenP2PTransactionSpec;
import org.ion.client.api.v1.TransactionAPI;
import org.ionexchange.v1.objects.TransactionView;
import org.ion.client.domain.TransactionAlias;
import org.ion.client.domain.finance.BankAccount;
import org.ion.client.domain.finance.IONSavingsAccount;
import org.ion.client.domain.transaction.TransactionProxy;
import org.ion.client.repository.ApplicationSessionRepository;
import org.ion.client.repository.SavingsAccountRepository;
import org.ion.client.repository.TransactionRepository;
import org.ion.client.repository.UserDataRepository;
import org.ion.client.services.*;
import org.ion.client.services.util.P2PTopupSessionData;
import org.ion.client.services.util.P2PTransactionSessionData;
import org.ion.client.services.util.P2PTransactionSessionStatus;
import org.ion.client.services.util.TopupSessionStatus;
import org.ion.client.domain.user.User;
import org.ion.util.EntityIdGenerator;
import org.ion.util.Tokenizer;
import org.ionexchange.v1.objects.*;

import java.util.List;

/**
 * // TODO Comment
 */
public class TransactionAPIImpl extends IONAPIBase implements TransactionAPI {
  private EntityIdGenerator _entityIdGenerator;
  private TransactionRepository _transactionRepository;
  private ApplicationSessionRepository _applicationSessionRepository;
  private UserPreferenceService _userPreferenceService;
  private SavingsAccountService _savingsAccountService;
  private SavingsAccountRepository _savingsAccountRepository;
  private UserDataRepository _userDataService;
  private Tokenizer _tokenizer;

  public TransactionAPIImpl() {
  }

  @Override
  public APIResponse<Void> openP2PTransaction(APIRequest<OpenP2PTransactionSpec> request) throws Exception {
    assert request != null;
    assert request.getData() != null;

    TransactionAlias creatorAlias = _transactionRepository.getTransactionAliasbyUsername(request.getData().getCreatorUsername());
    if (creatorAlias != null) {
      TransactionAlias attendantAlias = _transactionRepository.getTransactionAliasbyUsername(request.getData().getAttendantUsername());
      if (attendantAlias != null) {
        P2PTransactionSessionData p2PTransactionSessionData = new P2PTransactionSessionData();
        p2PTransactionSessionData.setCreatorAliasId(creatorAlias.getId());
        p2PTransactionSessionData.setAttendantAliasId(attendantAlias.getId());
        p2PTransactionSessionData.setStatus(P2PTransactionSessionStatus.OPEN);
        p2PTransactionSessionData.setSessionId(request.getData().getSessionId());
        _applicationSessionRepository.setP2PTransactionSession(p2PTransactionSessionData);
        return okResponse();
      } else {
        return failedResponse("Invited username does not exist");
      }
    } else {
      return failedResponse("The owner username does not exist");
    }
  }

  @Override
  public APIResponse<Void> acceptP2PTransactionInvitation(APIRequest<ApproveP2PTransactionSpec> request) throws Exception {
    assert request != null;
    assert request.getData() != null;

    P2PTransactionSessionData p2PTransactionSessionData = _applicationSessionRepository.getP2PTransactionSession(request.getData().getSessionId());
    if (p2PTransactionSessionData.getStatus() == P2PTransactionSessionStatus.OPEN) {
      TransactionAlias creatorAlias = _transactionRepository.getTransactionAliasbyUsername(p2PTransactionSessionData.getCreatorAliasId());
      if (creatorAlias != null) {
        TransactionAlias attendantAlias = _transactionRepository.getTransactionAliasbyUsername(p2PTransactionSessionData.getAttendantAliasId());
        if (attendantAlias != null) {
          _transactionRepository.createP2PTransactionGroup(creatorAlias, attendantAlias);
          return okResponse();
        } else {
          return failedResponse("Invited username does not exist anymore");
        }
      } else {
        return failedResponse("The owner username does not exist anymore");
      }
    }
    if (p2PTransactionSessionData.getStatus() == P2PTransactionSessionStatus.CONFIRMED) {
      return failedResponse("The transaction has been confirmed");
    }
    if (p2PTransactionSessionData.getStatus() == P2PTransactionSessionStatus.NA) {
      return failedResponse("The transaction does not exist anymore");
    }
    return failedResponse("The system does not recognize the transaction");
  }

  @Override
  public APIResponse<String> requestTopupToken(APIRequest<RequestTopupTokenSpec> request) throws Exception {
    assert request != null;
    assert request.getData() != null;

    BankAccount bankAccount = _savingsAccountRepository.getBankAccountById(request.getData().getBankAccountId());
    if (bankAccount != null) {

      P2PTopupSessionData p2PTopupSessionData = new P2PTopupSessionData();

      String newToken = _tokenizer.generateNewTopupToken();
      p2PTopupSessionData.setToken(newToken);

      p2PTopupSessionData.setBankAccount(bankAccount);
      p2PTopupSessionData.setSessionId(request.getData().getSessionId());
      p2PTopupSessionData.setTopupSessionStatus(TopupSessionStatus.ACTIVE);
      _applicationSessionRepository.setTopupSession(p2PTopupSessionData);
      return okResponse(newToken);
    } else {
      return failedResponse("The bank account does not exist");
    }
  }

  @Override
  public APIResponse<Void> createP2PMoneyTransfer(APIRequest<CreateP2PMoneyTransferSpec> request) throws Exception {
    assert request != null;
    assert request.getData() != null;

    if (request.getData().getAmount() > 0) {
      TransactionProxy srcTransactionProxy = _transactionRepository.getTransactionProxybyId(request.getData().getTransactionProxyId());
      if (srcTransactionProxy != null) {
        TransactionProxy dstTransactionProxy = _transactionRepository.getP2PPartnerInGroupByTransactionId(request.getData().getTransactionProxyId());
        if (dstTransactionProxy != null) {
          IONSavingsAccount srcSavingAccount = _userPreferenceService.getDefaultSavingAccountByTransactionProxy(srcTransactionProxy);
          if (srcSavingAccount != null) {
            IONSavingsAccount dstSavingAccount = _userPreferenceService.getDefaultSavingAccountByTransactionProxy(dstTransactionProxy);
            if (dstSavingAccount != null) {
              if (srcSavingAccount.getBalance() >= request.getData().getAmount()) {
                _savingsAccountService.moveMoneyInterSavingsAccount(srcSavingAccount, dstSavingAccount, request.getData().getAmount());
                return okResponse();
              } else {
                return failedResponse("The saving amount is not sufficient for transfer");
              }
            } else {
              return failedResponse("The destination account is not available");
            }
          } else {
            return failedResponse("User has no a default saving account");
          }
        } else {
          return failedResponse("The destination user is not in contact");

        }
      } else {
        return failedResponse("The user has no transaction alias");
      }
    } else {
      return failedResponse("The amount must be more that zero");
    }
  }

  @Override
  public APIResponse<IncomingTransactionData> getIncomingTransactions(APIRequest<GetIncomingTransactionsSpec> request) throws Exception {
    assert request != null;
    assert request.getData() != null;

    TransactionAlias transactionAlias = _transactionRepository.getTransactionAliasbyId(request.getData().getTransactionAliasId());
    if (transactionAlias != null) {
      List<TransactionView> incomingTransactions = _transactionRepository.getUnreadTransactions(transactionAlias, request.getData().getLimit(), request.getData().getSkip());
      if (incomingTransactions != null && !incomingTransactions.isEmpty()) {
        IncomingTransactionData incomingTransactionData = new IncomingTransactionData();
        incomingTransactionData.setTransactionList(incomingTransactions);
        return okResponse(incomingTransactionData);
      } else {
        return failedResponse("The incoming transactions is not available");
      }
    } else {
      return failedResponse("The transaction profile is not available");
    }
  }

  @Override
  public APIResponse<Void> createTextTransfer(APIRequest<CreateTextTransferSpec> request) throws Exception {
    assert request != null;
    assert request.getData() != null;

    TransactionProxy srcTransactionProxy = _transactionRepository.getTransactionProxybyId(request.getData().getTransactionProxyId());
    if (srcTransactionProxy != null) {
      _transactionRepository.createP2PTextTransaction(srcTransactionProxy, request.getData().getText());
      return okResponse();
    } else {
      return failedResponse("The user has no contact with destination user");
    }
  }

  @Override
  public APIResponse<Void> createToBankTransfer(APIRequest<ToBankTransferCreationSpec> request) throws Exception {
    assert request != null;
    assert request.getData() != null;

    if (request.getData().getAmount() > 0) {
      User user = _userDataService.getUserById(request.getData().getUserId());
      if (user != null) {
        BankAccount dstBankAccount = _savingsAccountRepository.getBankAccountById(request.getData().getBankAccountId());
        if (dstBankAccount != null) {
          IONSavingsAccount srcIONSavingsAccount = _savingsAccountRepository.getSavingAccountById(request.getData().getSavingAccountId());
          if (srcIONSavingsAccount != null) {
            if (srcIONSavingsAccount.getBalance() > request.getData().getAmount()) {
              _savingsAccountService.moveMoneyFromInternalToBank(srcIONSavingsAccount, dstBankAccount);
              return okResponse();
            } else {
              return failedResponse("The saving amount is not sufficient for bank transfer");
            }
          } else {
            return failedResponse("The default saving account does not exist");
          }
        } else {
          return failedResponse("The destination bank account does not exist");
        }
      } else {
        return failedResponse("The user does not exist");
      }
    } else {
      return failedResponse("The transfer amount must be more than zero");
    }
  }


}
