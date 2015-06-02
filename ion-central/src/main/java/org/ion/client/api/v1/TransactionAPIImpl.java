package org.ion.client.api.v1;

import org.ion.client.domain.TransactionAlias;
import org.ion.client.domain.finance.BankAccount;
import org.ion.client.domain.finance.IONSavingsAccount;
import org.ion.client.domain.transaction.Transaction;
import org.ion.client.domain.transaction.TransactionProxy;
import org.ion.client.services.*;
import org.ion.client.services.util.P2PTopupSessionData;
import org.ion.client.services.util.P2PTopupSessionSpec;
import org.ion.client.services.util.P2PTransactionSessionData;
import org.ion.client.services.util.P2PTransactionSessionSpec;
import org.ion.client.services.util.P2PTransactionSessionStatus;
import org.ion.client.services.util.TopupToken;
import org.ion.client.domain.user.User;
import org.ionexchange.v1.objects.*;

import java.io.IOException;
import java.util.List;

/**
 * // TODO Comment
 */
public class TransactionAPIImpl extends IONAPIBase implements TransactionAPI {
    private EntityIdGeneratorService _entityIdGeneratorService;
    private TransactionService _transactionService;
    private ApplicationSessionService _applicationSessionService;
    private FinancialTransactionService _financialTransactionService;
    private SavingsAccountService _savingsAccountService;
    private UserDataService _userDataService;

    public TransactionAPIImpl() {
    }

    @Override
    public APIResponse<Void> openP2PTransaction(APIRequest<OpenP2PTransactionSpec> request) throws IOException {
        assert request != null;
        assert request.getData() != null;

        TransactionAlias creatorAlias = _transactionService.getTransactionAliasbyUsername(request.getData().getCreatorUsername());
        if (creatorAlias != null) {
            TransactionAlias attendantAlias = _transactionService.getTransactionAliasbyUsername(request.getData().getAttendantUsername());
            if (attendantAlias != null) {
                P2PTransactionSessionSpec p2PTransactionSessionSpec = new P2PTransactionSessionSpec();
                p2PTransactionSessionSpec.setCreatorAliasId(creatorAlias.getId());
                p2PTransactionSessionSpec.setAttendantAliasId(attendantAlias.getId());
                _applicationSessionService.createP2PTransactionSession(p2PTransactionSessionSpec);
                return okResponse();
            } else {
                return failedResponse("Invited username does not exist");
            }
        } else {
            return failedResponse("The owner username does not exist");
        }
    }

    @Override
    public APIResponse<Void> acceptP2PTransaction(APIRequest<ApproveP2PTransactionSpec> request) throws IOException {
        assert request != null;
        assert request.getData() != null;

        P2PTransactionSessionData p2PTransactionSessionData = _applicationSessionService.getP2PTransactionSession(request.getData().getSessionId());
        if (p2PTransactionSessionData.getStatus() == P2PTransactionSessionStatus.OPEN) {
            TransactionAlias creatorAlias = _transactionService.getTransactionAliasbyUsername(p2PTransactionSessionData.getCreatorAliasId());
            if (creatorAlias != null) {
                TransactionAlias attendantAlias = _transactionService.getTransactionAliasbyUsername(p2PTransactionSessionData.getAttendantAliasId());
                if (attendantAlias != null) {
                    _transactionService.createP2PTransaction(creatorAlias, attendantAlias);
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
    public APIResponse<TopupToken> requestTopupToken(APIRequest<RequestTopupTokenSpec> request) throws IOException {
        assert request != null;
        assert request.getData() != null;

        IONSavingsAccount bankAccount = _transactionService.getBankAccountById(request.getData().getSavingAccountId());
        if (bankAccount != null) {
            P2PTopupSessionSpec p2PTopupSessionSpec = new P2PTopupSessionSpec();
            p2PTopupSessionSpec.setBankAccountTarget(bankAccount);
            P2PTopupSessionData p2PTopupSessionData = _applicationSessionService.createTopupSession(p2PTopupSessionSpec);
            TopupToken topupToken = new TopupToken();
            topupToken.setToken(p2PTopupSessionData.getToken());
            return okResponse(topupToken);
        } else {
            return failedResponse("The bank account does not exist");
        }
    }

    @Override
    public APIResponse<Void> createP2PMoneyTransfer(APIRequest<CreateP2PMoneyTransferSpec> request) throws IOException {
        assert request != null;
        assert request.getData() != null;

        if (request.getData().getAmount() > 0) {
            TransactionProxy srcTransactionProxy = _transactionService.getTransactionProxybyId(request.getData().getTransactionProxyId());
            if (srcTransactionProxy != null) {
                TransactionProxy dstTransactionProxy = _transactionService.getP2PPartnerInGroupByTransactionId(request.getData().getTransactionProxyId());
                if (dstTransactionProxy != null) {
                    IONSavingsAccount srcSavingAccount = _financialTransactionService.getDefaultSavingAccountByTransactionProxy(srcTransactionProxy);
                    if (srcSavingAccount != null) {
                        IONSavingsAccount dstSavingAccount = _financialTransactionService.getDefaultSavingAccountByTransactionProxy(dstTransactionProxy);
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
    public APIResponse<IncomingTransactionData> getIncomingTransactions(APIRequest<GetIncomingTransactionsSpec> request) throws IOException {
      assert request!=null;
      assert request.getData()!=null;

      TransactionAlias transactionAlias = _transactionService.getTransactionAliasbyId(request.getData().getTransactionAliasId());
      if(transactionAlias!=null){
        List<Transaction> incomingTransactions = _transactionService.getUnreadTransactions(transactionAlias,request.getData().getLimit(),request.getData().getSkip());
        if(incomingTransactions!=null && !incomingTransactions.isEmpty()){
          IncomingTransactionData incomingTransactionData = new IncomingTransactionData();
          incomingTransactionData.setTransactionList(incomingTransactions);
          return okResponse(incomingTransactionData);
        }
        else
        {
          return failedResponse("The incoming transactions is not available");
        }
      }
      else
      {
        return failedResponse("The transaction profile is not available");
      }
    }

    @Override
    public APIResponse<Void> createTextTransfer(APIRequest<CreateTextTransferSpec> request) throws IOException {
        assert request != null;
        assert request.getData() != null;

        TransactionProxy srcTransactionProxy = _transactionService.getTransactionProxybyId(request.getData().getTransactionProxyId());
        if (srcTransactionProxy != null) {
            _transactionService.createP2PTextTransaction(srcTransactionProxy, request.getData().getText());
            return okResponse();
        } else {
            return failedResponse("The user has no contact with destination user");
        }
    }

    @Override
    public APIResponse<Void> createToBankTransfer(APIRequest<ToBankTransferCreationSpec> request) throws IOException {
        assert request != null;
        assert request.getData() != null;

        if (request.getData().getAmount() > 0) {
            User user = _userDataService.getUserById(request.getData().getUserId());
            if (user != null) {
                BankAccount dstBankAccount = _savingsAccountService.getBankAccountById(request.getData().getUserId());
                if (dstBankAccount != null) {
                    IONSavingsAccount srcIONSavingsAccount = _savingsAccountService.getDefaultIONSavingsAccountByUserId(request.getData().getUserId());
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
