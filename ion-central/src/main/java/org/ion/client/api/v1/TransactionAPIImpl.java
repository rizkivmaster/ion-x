package org.ion.client.api.v1;

import org.ion.client.domain.TransactionAlias;
import org.ion.client.domain.transaction.Transaction;
import org.ion.client.services.ApplicationSessionService;
import org.ion.client.services.EntityIdGeneratorService;
import org.ion.client.services.P2PTransactionSessionData;
import org.ion.client.services.P2PTransactionSessionSpec;
import org.ion.client.services.P2PTransactionSessionStatus;
import org.ion.client.services.TopupTokenCreationData;
import org.ion.client.services.TransactionService;
import org.ionexchange.v1.objects.*;

import java.io.IOException;

/**
 * // TODO Comment
 */
public class TransactionAPIImpl extends IONAPIBase implements TransactionAPI {
  private EntityIdGeneratorService _entityIdGeneratorService;
  private TransactionService _transactionService;
  private ApplicationSessionService _applicationSessionService;

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
}
