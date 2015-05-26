package org.ion.client.api.v1;

import org.ion.client.services.EntityIdGeneratorService;
import org.ion.client.services.TopupTokenCreationData;
import org.ionexchange.v1.objects.*;

/**
 * // TODO Comment
 */
public class TransactionAPIImpl extends IONAPIBase implements TransactionAPI {
  private EntityIdGeneratorService _entityIdGeneratorService;

  public TransactionAPIImpl() {
  }

  @Override
  public RequestTopupTokenRequest requestTopupToken(RequestTopupTokenSpec requestTopupTokenSpec) {
    TopupTokenCreationData topupTokenCreationData = new TopupTokenCreationData();
    topupTokenCreationData
    return null;  // TODO impl
  }

  @Override
  public CreateP2PMoneyTransfer createP2PMoneyTransfer(CreateP2PMoneyTransferSpec createP2PMoneyTransferSpec) {
    return null;  // TODO impl
  }

  @Override
  public GetIncomingMoneyTransactionResult getIncomingMoneyTransactionResult(GetIncomingMoneyTransactionSpec getIncomingMoneyTransactionSpec) {
    return null;  // TODO impl
  }

  @Override
  public CreateTextTransferResult createTextTransfer(CreateTextTransferSpec createTextTransferSpec) {
    return null;  // TODO impl
  }

  @Override
  public GetIncomingMessagesResult getIncomingMessages(GetIncomingMessagesSpec getIncomingMessagesSpec) {
    return null;  // TODO impl
  }

  @Override
  public ToBankTransferCreationResult createToBankTransfer(ToBankTransferCreationSpec toBankTransferCreationSpec) {
    return null;  // TODO impl
  }
}
