package com.beta.replyservice.operations;

import com.beta.replyservice.services.operations.IRuleBasedOperation;
import com.beta.replyservice.services.operations.RuleBasedOperation;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RuleBasedOperationReverseStringTest {

    private final IRuleBasedOperation ruleBasedOperation = new RuleBasedOperation();
    private final int REVERSE_STRING_RULE = 1;


    @Test
    public void testReverseString() {
        String message = "123";

        String expectedResult = "321";
        String actualResult = ruleBasedOperation.processRuleBasedOperation(REVERSE_STRING_RULE, message);

        Assertions.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testReverseEmptyString() {
        String message = "";

        String expectedResult = "";
        String actualResult = ruleBasedOperation.processRuleBasedOperation(REVERSE_STRING_RULE, message);

        Assertions.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testReverseNullString() {
        String message = null;

        String expectedResult = null;
        String actualResult = ruleBasedOperation.processRuleBasedOperation(REVERSE_STRING_RULE, message);

        Assertions.assertEquals(expectedResult, actualResult);
    }

}
