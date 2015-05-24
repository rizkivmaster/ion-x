package org.ion.client.api.v1;

import org.ionexchange.v1.router.Routers;
import org.ionexchange.v1.objects.*;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * // TODO Comment
 */
public interface TransactionAPI {

  RequestTopupTokenRequest requestTopupToken(RequestTopupTokenSpec requestTopupTokenSpec);

  CreateP2PMoneyTransfer createP2PMoneyTransfer(CreateP2PMoneyTransferSpec createP2PMoneyTransferSpec);

  GetIncomingMoneyTransactionResult getIncomingMoneyTransactionResult(GetIncomingMoneyTransactionSpec getIncomingMoneyTransactionSpec);

  CreateTextTransferResult createTextTransfer(CreateTextTransferSpec createTextTransferSpec);

  GetIncomingMessagesResult getIncomingMessages(GetIncomingMessagesSpec getIncomingMessagesSpec);

  ToBankTransferCreationResult createToBankTransfer(ToBankTransferCreationSpec toBankTransferCreationSpec);
}
