package com.beta.replyservice.services.operations;

public interface IRuleBasedOperation {
    String processRuleBasedOperation(int rule, String message);
}
