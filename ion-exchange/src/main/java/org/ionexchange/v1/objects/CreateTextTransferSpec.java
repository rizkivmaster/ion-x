package org.ionexchange.v1.objects;

/**
 * // TODO Comment
 */
public class CreateTextTransferSpec {
  private String _text;
  private String _transactionProxyId;

  public CreateTextTransferSpec() {
  }

  public String getText() {
    return _text;
  }

  public void setText(String text) {
    _text = text;
  }

  public String getTransactionProxyId() {
    return _transactionProxyId;
  }

  public void setTransactionProxyId(String transactionProxyId) {
    _transactionProxyId = transactionProxyId;
  }
}
