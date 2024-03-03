package com.beta.replyservice.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MessageConfiguration {

    @Value("${rule.message.separator}")
    private String ruleMessageSeparatorProperty;

    @Bean
    public String ruleMessageSeparator() {
        return ruleMessageSeparatorProperty;
    }
}
