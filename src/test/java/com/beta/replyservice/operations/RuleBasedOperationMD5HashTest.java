package com.beta.replyservice.operations;

import com.beta.replyservice.services.operations.IRuleBasedOperation;
import com.beta.replyservice.services.operations.RuleBasedOperation;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RuleBasedOperationMD5HashTest {

    private final IRuleBasedOperation ruleBasedOperation = new RuleBasedOperation();
    private final int MD5_HASH_STRING_RULE = 2;
    
    @Test
    public void testHashStringToMD5() {
        String message = "kbzw9ru";

        String expectedResult = "0fafeaae780954464c1b29f765861fad";
        String actualResult = ruleBasedOperation.processRuleBasedOperation(MD5_HASH_STRING_RULE, message);

        Assertions.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testHashEmptyStringToMD5() {
        String message = "";

        String expectedResult = "d41d8cd98f00b204e9800998ecf8427e";
        String actualResult = ruleBasedOperation.processRuleBasedOperation(MD5_HASH_STRING_RULE, message);

        Assertions.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testHashNullStringToMD5() {
        String message = null;

        String expectedResult = null;
        String actualResult = ruleBasedOperation.processRuleBasedOperation(MD5_HASH_STRING_RULE, message);

        Assertions.assertEquals(expectedResult, actualResult);
    }
}
