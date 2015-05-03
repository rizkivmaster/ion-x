package org.ion.client.services;

import org.ion.client.services.util.TopUpCancellationResult;
import org.ion.client.services.util.TopUpCancellationSpec;
import org.ion.client.services.util.TopUpConfirmationSpec;
import org.ion.client.services.util.TopUpConfirmationResult;
import org.ion.client.services.util.TopUpTokenCreationResult;
import org.ion.client.services.util.TopUpTokenCreationSpec;

/**
 * Created by rizkivmaster on 4/23/15.
 */

public interface TransactionService {
  /*
   * TopUp related service
   */
  public void createTopUpToken(String username, long amount) throws Exception;
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

  public void p2pTransfer(String srcUsername, String dstUsername, long amount) throws Exception;
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