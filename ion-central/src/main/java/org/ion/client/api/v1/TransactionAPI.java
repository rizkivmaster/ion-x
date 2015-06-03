package org.ion.client.api.v1;

import org.ionexchange.v1.objects.*;

/**
 * // TODO Comment
 */
public interface TransactionAPI {

  APIResponse<Void> openP2PTransaction(APIRequest<OpenP2PTransactionSpec> request) throws Exception;

  APIResponse<Void> acceptP2PTransactionInvitation(APIRequest<ApproveP2PTransactionSpec> request) throws Exception;

  APIResponse<String> requestTopupToken(APIRequest<RequestTopupTokenSpec> request) throws Exception;

  APIResponse<Void> createP2PMoneyTransfer(APIRequest<CreateP2PMoneyTransferSpec> request) throws Exception;

  APIResponse<IncomingTransactionData> getIncomingTransactions(APIRequest<GetIncomingTransactionsSpec> request) throws Exception;

  APIResponse<Void> createTextTransfer(APIRequest<CreateTextTransferSpec> request) throws Exception;

  APIResponse<Void> createToBankTransfer(APIRequest<ToBankTransferCreationSpec> request) throws Exception;
}
