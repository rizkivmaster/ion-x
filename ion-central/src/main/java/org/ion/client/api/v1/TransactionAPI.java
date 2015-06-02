package org.ion.client.api.v1;

import org.ion.client.services.util.TopupToken;
import org.ionexchange.v1.objects.*;

import java.io.IOException;

/**
 * // TODO Comment
 */
public interface TransactionAPI {

  APIResponse<Void> openP2PTransaction(APIRequest<OpenP2PTransactionSpec> request) throws IOException;

  APIResponse<Void> acceptP2PTransaction(APIRequest<ApproveP2PTransactionSpec> request) throws IOException;

  APIResponse<TopupToken> requestTopupToken(APIRequest<RequestTopupTokenSpec> request) throws IOException;

  APIResponse<Void> createP2PMoneyTransfer(APIRequest<CreateP2PMoneyTransferSpec> request) throws IOException;

  APIResponse<IncomingTransactionData> getIncomingTransactions(APIRequest<GetIncomingTransactionsSpec> request) throws IOException;

  APIResponse<Void> createTextTransfer(APIRequest<CreateTextTransferSpec> request) throws IOException;

  APIResponse<Void> createToBankTransfer(APIRequest<ToBankTransferCreationSpec> request) throws IOException;
}
