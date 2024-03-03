package com.beta.replyservice.services.parsers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("MessageParser")
public class MessageParser implements Parser<String, String> {

    @Autowired
    private String ruleMessageSeparator;

    @Override
    public String getValue(String input) {
        int separatorIndex = input.indexOf(ruleMessageSeparator);

        if (separatorIndex == input.length() - 1 || separatorIndex == -1) {
            return "";
        }

        return input.substring(separatorIndex + 1);
    }
}