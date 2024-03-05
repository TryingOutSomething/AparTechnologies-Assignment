package com.beta.replyservice.configuration;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class RequestErrorMessageTest {

    @Autowired
    private RequestErrorMessage requestErrorMessage;

    @Test
    public void testGetInvalidRuleMessage() {
        String expectedResult = "Invalid Rule";
        String actualResult = requestErrorMessage.getInvalidRule();

        Assertions.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testGetEmptyMessage() {
        String expectedResult = "Message Cannot Be Empty";
        String actualResult = requestErrorMessage.getEmptyMessage();

        Assertions.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testGetNullInoutMessage() {
        String expectedResult = "Invalid Message";
        String actualResult = requestErrorMessage.getNullInput();

        Assertions.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testGetNoSeparatorMessage() {
        String expectedResult = "No Separator Provided";
        String actualResult = requestErrorMessage.getNoSeparator();

        Assertions.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testGetRuleNotWhitelistedMessage() {
        String expectedResult = "No Such Rule";
        String actualResult = requestErrorMessage.getRuleNotWhitelisted();

        Assertions.assertEquals(expectedResult, actualResult);
    }
}
