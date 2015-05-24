package org.ion.client.api.v1;

import org.ionexchange.v1.objects.*;

/**
 * // TODO Comment
 */
public interface NotificationAPI {
  CheckNewUserContactRequestResult checkNewUserContactRequest(CheckNewUserContactRequestSpec checkNewUserContactRequestSpec);

  CheckTopupCompletionResult checkTopupCompletion(CheckTopupCompletionSpec checkTopupCompletionSpec);

  CheckIncomingMoneyTransactionResult checkIncomingMoneyTransaction(CheckIncomingMoneyTransactionSpec checkIncomingMoneyTransactionSpec);

  CheckIncomingMessagesResult checkIncomingMessagesResult(CheckIncomingMessagesSpec checkIncomingMessagesSpec);

  CheckToBankTransferStatusResult checkToBankTransferStatus(CheckToBankTransferStatusSpec checkToBankTransferStatusSpec);
}
