package com.beta.replyservice.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "rule")
public class MessageConfiguration {

    private String separator;
    private String[] range;

    public String getSeparator() {
        return separator;
    }

    public void setSeparator(String separator) {
        this.separator = separator;
    }

    public String[] getRange() {
        return range;
    }

    public void setRange(String[] range) {
        this.range = range;
    }
}
