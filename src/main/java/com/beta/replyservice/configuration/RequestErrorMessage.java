package com.beta.replyservice.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * A helper class to get error messages from the message.properties file.
 * These error messages are used with the ValidationError class to provide users with more information if
 * they have any mistakes in their input.
 */
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

    /**
     * Gets prefix message from the "request.error.prefix" property. This message is prepended to the
     * validation error message
     *
     * @return the prefix
     */
    public String getPrefix() {
        return prefix;
    }

    // Method has no access modifier to prevent others from modifying the value
    void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    /**
     * Gets invalid rule from the "request.error.invalidRule" property
     *
     * @return the invalid rule
     */
    public String getInvalidRule() {
        return invalidRule;
    }

    // Method has no access modifier to prevent others from modifying the value
    void setInvalidRule(String invalidRule) {
        this.invalidRule = invalidRule;
    }

    /**
     * Gets invalid rule length from the "request.error.invalidRuleLength" property
     *
     * @return the invalid rule length
     */
    public String getInvalidRuleLength() {
        return invalidRuleLength;
    }

    // Method has no access modifier to prevent others from modifying the value
    void setInvalidRuleLength(String invalidRuleLength) {
        this.invalidRuleLength = invalidRuleLength;
    }

    /**
     * Gets empty message from the "request.error.emptyMessage" property
     *
     * @return the empty message
     */
    public String getEmptyMessage() {
        return emptyMessage;
    }

    // Method has no access modifier to prevent others from modifying the value
    void setEmptyMessage(String emptyMessage) {
        this.emptyMessage = emptyMessage;
    }

    /**
     * Gets null input from the "request.error.nullInput" property
     *
     * @return the null input
     */
    public String getNullInput() {
        return nullInput;
    }

    // Method has no access modifier to prevent others from modifying the value
    void setNullInput(String nullInput) {
        this.nullInput = nullInput;
    }

    /**
     * Gets no separator from the "request.error.noSeparator" property
     *
     * @return the no separator
     */
    public String getNoSeparator() {
        return noSeparator;
    }

    // Method has no access modifier to prevent others from modifying the value
    void setNoSeparator(String noSeparator) {
        this.noSeparator = noSeparator;
    }

    /**
     * Gets rule not whitelisted from the "request.error.ruleNotWhitelisted" property
     *
     * @return the rule not whitelisted
     */
    public String getRuleNotWhitelisted() {
        return ruleNotWhitelisted;
    }

    // Method has no access modifier to prevent others from modifying the value
    void setRuleNotWhitelisted(String ruleNotWhitelisted) {
        this.ruleNotWhitelisted = ruleNotWhitelisted;
    }

    /**
     * Gets rule not numeric from the "request.error.ruleNotNumeric" property
     *
     * @return the rule not numeric
     */
    public String getRuleNotNumeric() {
        return ruleNotNumeric;
    }

    // Method has no access modifier to prevent others from modifying the value
    void setRuleNotNumeric(String ruleNotNumeric) {
        this.ruleNotNumeric = ruleNotNumeric;
    }
}
