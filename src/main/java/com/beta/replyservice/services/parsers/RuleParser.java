package com.beta.replyservice.services.parsers;

import com.beta.replyservice.configuration.MessageConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("RuleParser")
public class RuleParser implements Parser<String, String> {

    @Autowired
    private MessageConfiguration config;

    @Override
    public String getValue(String input) {
        int separatorIndex = input.indexOf(config.getSeparator());

        if (separatorIndex == -1) {
            return input;
        }

        return input.substring(0, separatorIndex);
    }
}
