package org.ion.client.services;

import org.ion.client.api.v1.TransactionProxy;
import org.ion.client.domain.TransactionAlias;
import org.ion.client.domain.transaction.IONSavingAccount;
import org.ion.client.domain.transaction.Transaction;
import org.ion.client.domain.user.BankAccount;

import java.io.IOException;
import java.util.List;

/**
 * Created by rizkivmaster on 4/23/15.
 */

public interface TransactionService {
  /*
   * TopUp related service
   */

  TransactionAlias getTransactionAliasbyUsername(String username) throws IOException;

  TransactionAlias getTransactionAliasbyId(String id);

  void createP2PTransaction(TransactionAlias creatorAlias, TransactionAlias attendantAlias) throws IOException;

  BankAccount getBankAccountById(String id);

  void reloadBalance(BankAccount srcBankAccount, IONSavingAccount dstIONSavingAccount,long amount) throws Exception;

  void unloadBalance(IONSavingAccount srcIONSavingAccount, BankAccount dstBankAccount, long amount) throws  Exception;



  IONSavingAccount getDefaultIONSavingAccount(User user);

  TransactionProxy getTransactionProxybyId(String id);

  TransactionProxy getP2PPartnerInGroupByTransactionId(String id);

  P2PTransactionGroup getP2PTransactionGroupById(String id);

  void createP2PTextTransaction(TransactionProxy transactionProxy, String text);

  List<Transaction> getUnreadTransactions(TransactionAlias transactionAlias, int size, int skip);


//  public TopUpConfirmationResult confirmTopUp(TopUpConfirmationSpec topUpConfirmationRequestSpec);
//  public TopUpCancellationResult cancelTopUp(TopUpCancellationSpec topUpCancellationRequestSpec);

  /*
   * ToBank Transfer related service
   */

//  public ToBankTransferResult createToBankTransfer(ToBankTransferSpec toBankTransferSpec);

  /*
   * Group Transaction related service
   */
 /* public ToGroupTransferCreationResult createToGroupTransfer(ToGroupTransferCreationSpec toGroupTransferSpec);
  public ToGroupTransferConfirmationResult confirmToGroupTransfer(ToGroupTransferConfirmationSpec toGroupTransferConfirmationSpec);
  public ToGroupTransferConfirmationResult cancelToGroupTransfer(ToGroupTransferCancelationSpec toGroupTransferCancelationSpec);
*/
  /*
   * P2P Transaction related service
   */


  /*public void confirmP2PTransfer(P2PTransferConfirmationSpec p2PTransferConfirmationSpec);
  public void cancelP2PTransfer(P2PTransferCancelationSpec p2PTransferCancelationSpec);*/
  /*
   * Commerce related service
   */

 /* public PaymentCreationResult createPayment(PaymentCreationSpec paymentCreationSpec);
  public PaymentConfirmationResult confirmPayment(PaymentConfirmationSpec paymentConfirmationSpec);
  public PaymentCancelationResult cancelPayment(PaymentCancelationSpec paymentCancelationSpec);
*/

}
