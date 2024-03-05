package com.beta.replyservice.services.operations;

/**
 * The interface Rule based operation.
 */
public interface IRuleBasedOperation {
    String processRuleBasedOperation(String rules, String message);
}
