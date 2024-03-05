package com.beta.replyservice.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

@Configuration
@ConfigurationProperties(prefix = "rule")
public class RuleConfiguration {

    private String separator;
    private int minLength;
    private Set<Integer> whitelist;

    public String getSeparator() {
        return separator;
    }

    public void setSeparator(String separator) {
        this.separator = separator;
    }

    public int getMinLength() {
        return minLength;
    }

    public void setMinLength(int minLength) {
        this.minLength = minLength;
    }

    public Set<Integer> getWhitelist() {
        return whitelist;
    }

    public void setWhitelist(int[] whitelist) {
        this.whitelist = Arrays.stream(whitelist).boxed().collect(Collectors.toSet());
    }
}
