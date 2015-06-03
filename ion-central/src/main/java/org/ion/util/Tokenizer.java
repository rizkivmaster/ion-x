package org.ion.util;

/**
 * // TODO Comment
 */
public interface Tokenizer {
  String generateNewRegistrationToken();
  String generateNewTopupToken();
  String generateNewSessionId();
}
