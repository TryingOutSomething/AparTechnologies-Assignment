package com.beta.replyservice.configuration;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MessageConfigurationTest {

    @Value("${rule.separator}")
    private String messageSeparatorProperty;
    @Value("${rule.range}")
    private int[] ruleAllowableRangeProperty;
    @Autowired
    private MessageConfiguration config;

    @Test
    public void testGetRulesMessageSeparatorProperty() {
        Assertions.assertEquals(config.getSeparator(), messageSeparatorProperty);
    }

    @Test
    public void testGetValidRulesRangeProperty() {
        int[] allowedRulesRange = config.getRange();

        int arrayPropertyLength = ruleAllowableRangeProperty.length;
        int validRulesRangeLength = allowedRulesRange.length;

        Assertions.assertEquals(arrayPropertyLength, validRulesRangeLength);

        for (int i = 0; i < arrayPropertyLength; i++) {
            int arrayProperty = ruleAllowableRangeProperty[i];
            int validRule = allowedRulesRange[i];

            Assertions.assertEquals(arrayProperty, validRule);
        }

        Assertions.assertEquals(true, true);
    }
}
