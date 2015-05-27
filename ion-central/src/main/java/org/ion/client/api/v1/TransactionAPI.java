package org.ion.client.api.v1;

import org.ionexchange.v1.objects.*;

import java.io.IOException;

/**
 * // TODO Comment
 */
public interface TransactionAPI {

  APIResponse<Void> openP2PTransaction(APIRequest<OpenP2PTransactionSpec> request) throws IOException;

  APIResponse<Void> acceptP2PTransaction(APIRequest<ApproveP2PTransactionSpec> request) throws IOException;

  APIResponse<Void> requestTopupToken(APIRequest<RequestTopupTokenSpec> request);

  APIResponse<Void> confirmTopupToken(APIRequest<ConfirmTopupTokenSpec> request);

  APIResponse<Void> createP2PMoneyTransfer(CreateP2PMoneyTransferSpec createP2PMoneyTransferSpec);

  APIResponse<Void> getIncomingMoneyTransactionResult(GetIncomingMoneyTransactionSpec getIncomingMoneyTransactionSpec);

  APIResponse<Void> createTextTransfer(CreateTextTransferSpec createTextTransferSpec);

  APIResponse<Void> getIncomingMessages(GetIncomingMessagesSpec getIncomingMessagesSpec);

  APIResponse<Void> createToBankTransfer(ToBankTransferCreationSpec toBankTransferCreationSpec);
}
