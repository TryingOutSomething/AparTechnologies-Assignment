package com.beta.replyservice.configuration;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Set;

@SpringBootTest
public class MessageConfigurationTest {

    @Value("${rule.separator}")
    private String messageSeparatorProperty;
    @Value("${rule.whitelist}")
    private int[] ruleWhitelistProperty;
    @Autowired
    private MessageConfiguration config;

    @Test
    public void testGetRulesMessageSeparatorProperty() {
        Assertions.assertEquals(config.getSeparator(), messageSeparatorProperty);
    }

    @Test
    public void testGetRulesWhitelistProperty() {
        Set<Integer> allowedRulesRange = config.getWhitelist();

        int arrayPropertyLength = ruleWhitelistProperty.length;
        int validRulesRangeLength = allowedRulesRange.size();

        Assertions.assertEquals(arrayPropertyLength, validRulesRangeLength);

        boolean expectedResult = true;

        for (int i = 0; i < arrayPropertyLength; i++) {
            int arrayProperty = ruleWhitelistProperty[i];
            boolean actualResult = allowedRulesRange.contains(arrayProperty);

            Assertions.assertEquals(expectedResult, actualResult);
        }
    }

    @Test
    public void testRulesInWhitelistProperty() {
        Set<Integer> allowedRulesRange = config.getWhitelist(); // modify whitelist in application.properties file

        int rule = 2;
        boolean expectedResult = true;
        boolean actualResult = allowedRulesRange.contains(rule);

        Assertions.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testRulesNotInWhitelistProperty() {
        Set<Integer> allowedRulesRange = config.getWhitelist(); // modify whitelist in application.properties file

        int rule = 3;
        boolean expectedResult = false;
        boolean actualResult = allowedRulesRange.contains(rule);

        Assertions.assertEquals(expectedResult, actualResult);
    }
}
