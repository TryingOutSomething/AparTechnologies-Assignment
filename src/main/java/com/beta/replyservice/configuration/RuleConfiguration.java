package com.beta.replyservice.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * A helper class to read rules properties from the application.properties file
 */
@Configuration
@ConfigurationProperties(prefix = "rule")
public class RuleConfiguration {

    private String separator;
    private int minLength;
    private Set<Integer> whitelist;

    /**
     * Gets separator from the "rule.separator" property
     *
     * @return the separator
     */
    public String getSeparator() {
        return separator;
    }

    // Method has no access modifier to prevent others from modifying the value
    void setSeparator(String separator) {
        this.separator = separator;
    }

    /**
     * Gets min length from the "rule.minLength" property
     *
     * @return the min length
     */
    public int getMinLength() {
        return minLength;
    }

    // Method has no access modifier to prevent others from modifying the value
    void setMinLength(int minLength) {
        this.minLength = minLength;
    }

    /**
     * Gets whitelist from the "rule.whitelist" property
     *
     * @return the whitelist
     */
    public Set<Integer> getWhitelist() {
        return whitelist;
    }

    // Method has no access modifier to prevent others from modifying the value
    void setWhitelist(int[] whitelist) {
        this.whitelist = Arrays.stream(whitelist).boxed().collect(Collectors.toSet());
    }
}
