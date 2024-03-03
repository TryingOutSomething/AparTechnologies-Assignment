package com.beta.replyservice.configuration;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MessageConfigurationTest {

    @Value("${rule.message.separator}")
    private String messageSeparatorProperty;

    @Autowired
    private String ruleMessageSeparator;

    @Test
    public void testGetProperty() {
        Assertions.assertEquals(ruleMessageSeparator, messageSeparatorProperty);
    }
}
