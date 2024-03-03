package com.beta.replyservice.operations;

import com.beta.replyservice.services.operations.IRuleBasedOperation;
import com.beta.replyservice.services.operations.RuleBasedOperation;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RuleBasedOperationTest {

    private final IRuleBasedOperation ruleBasedOperation = new RuleBasedOperation();

    @Test
    public void testReverseString() {
        String rule = "1";
        String message = "kbzw9ru";

        String expectedResult = "ur9wzbk";
        String actualResult = ruleBasedOperation.processRuleBasedOperation(rule, message);

        Assertions.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testReverseEmptyString() {
        String rule = "1";
        String message = "";

        String expectedResult = "";
        String actualResult = ruleBasedOperation.processRuleBasedOperation(rule, message);

        Assertions.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testReverseNullString() {
        String rule = "1";
        String message = null;

        String expectedResult = null;
        String actualResult = ruleBasedOperation.processRuleBasedOperation(rule, message);

        Assertions.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testHashStringToMD5() {
        String rule = "2";
        String message = "kbzw9ru";

        String expectedResult = "0fafeaae780954464c1b29f765861fad";
        String actualResult = ruleBasedOperation.processRuleBasedOperation(rule, message);

        Assertions.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testHashEmptyStringToMD5() {
        String rule = "2";
        String message = "";

        String expectedResult = "d41d8cd98f00b204e9800998ecf8427e";
        String actualResult = ruleBasedOperation.processRuleBasedOperation(rule, message);

        Assertions.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testHashNullStringToMD5() {
        String rule = "2";
        String message = null;

        String expectedResult = null;
        String actualResult = ruleBasedOperation.processRuleBasedOperation(rule, message);

        Assertions.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testConsecutiveReverseStringToMD5() {
        String rule = "11";
        String message = "abc";

        String expectedResult = "abc";
        String actualResult = ruleBasedOperation.processRuleBasedOperation(rule, message);

        Assertions.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testConsecutiveHashStringToMD5() {
        String rule = "22";
        String message = "kbzw9ru";

        String expectedResult = "e8501e64cf0a9fa45e3c25aa9e77ffd5";
        String actualResult = ruleBasedOperation.processRuleBasedOperation(rule, message);

        Assertions.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testEvenConsecutiveReverseAndOneHashStringToMD5() {
        String rule = "11112";
        String message = "kbzw9ru";

        String expectedResult = "0fafeaae780954464c1b29f765861fad";
        String actualResult = ruleBasedOperation.processRuleBasedOperation(rule, message);

        Assertions.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testOddConsecutiveReverseAndOneHashStringToMD5() {
        String rule = "1112";
        String message = "kbzw9ru";

        String expectedResult = "5a8973b3b1fafaeaadf10e195c6e1dd4";
        String actualResult = ruleBasedOperation.processRuleBasedOperation(rule, message);

        Assertions.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testConsecutiveHashAndOneReverseStringToMD5() {
        String rule = "221";
        String message = "kbzw9ru";

        String expectedResult = "5dff77e9aa52c3e54af9a0fc46e1058e";
        String actualResult = ruleBasedOperation.processRuleBasedOperation(rule, message);

        Assertions.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testConsecutiveHashAndEvenConsecutiveReverseStringToMD5() {
        String rule = "2211";
        String message = "kbzw9ru";

        String expectedResult = "e8501e64cf0a9fa45e3c25aa9e77ffd5";
        String actualResult = ruleBasedOperation.processRuleBasedOperation(rule, message);

        Assertions.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testRandomMix() {
        /*
         * reverse, hash, reverse, hash x 3, reverse, hash x 2
         *
         * Walkthrough of steps to derive expected result:
         * Reverse: ur9wzbk
         * Hash: 5a8973b3b1fafaeaadf10e195c6e1dd4
         * Reverse: 4dd1e6c591e01fdaaeafaf1b3b3798a5
         * Hash 1: d99f222e544ddf4184e4b59ce8c59827
         * Hash 2: 96b882a63bc2ee9be1ef162bba361034
         * Hash 3: a81cd7434f82bc648533742e71e459b4
         * Reverse: 4b954e17e247335846cb28f4347dc18a
         * Hash 1: 7858e4b5c4e603f59c655169c26fbd97
         * Hahs 2: 9aa692531d6535b9c360c1071267a6fa
         */
        String rule = "1211122211122";
        String message = "kbzw9ru";

        String expectedResult = "9aa692531d6535b9c360c1071267a6fa";
        String actualResult = ruleBasedOperation.processRuleBasedOperation(rule, message);

        Assertions.assertEquals(expectedResult, actualResult);
    }
}
