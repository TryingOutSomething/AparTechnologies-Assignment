package com.beta.replyservice.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ConfigurationProperties(prefix = "request.error")
@PropertySource("classpath:message.properties")
public class RequestErrorMessage {

    private String prefix;
    private String invalidRule;
    private String invalidRuleLength;
    private String emptyMessage;
    private String nullInput;
    private String noSeparator;
    private String ruleNotWhitelisted;
    private String ruleNotNumeric;

    public String getPrefix() {
        return prefix;
    }

    void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public String getInvalidRule() {
        return invalidRule;
    }

    void setInvalidRule(String invalidRule) {
        this.invalidRule = invalidRule;
    }

    public String getInvalidRuleLength() {
        return invalidRuleLength;
    }

    void setInvalidRuleLength(String invalidRuleLength) {
        this.invalidRuleLength = invalidRuleLength;
    }

    public String getEmptyMessage() {
        return emptyMessage;
    }

    void setEmptyMessage(String emptyMessage) {
        this.emptyMessage = emptyMessage;
    }

    public String getNullInput() {
        return nullInput;
    }

    void setNullInput(String nullInput) {
        this.nullInput = nullInput;
    }

    public String getNoSeparator() {
        return noSeparator;
    }

    void setNoSeparator(String noSeparator) {
        this.noSeparator = noSeparator;
    }

    public String getRuleNotWhitelisted() {
        return ruleNotWhitelisted;
    }

    void setRuleNotWhitelisted(String ruleNotWhitelisted) {
        this.ruleNotWhitelisted = ruleNotWhitelisted;
    }

    public String getRuleNotNumeric() {
        return ruleNotNumeric;
    }

    void setRuleNotNumeric(String ruleNotNumeric) {
        this.ruleNotNumeric = ruleNotNumeric;
    }
}
