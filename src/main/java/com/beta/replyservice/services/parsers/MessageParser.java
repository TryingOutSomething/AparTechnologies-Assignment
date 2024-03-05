package com.beta.replyservice.services.parsers;

import com.beta.replyservice.configuration.RuleConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * The concrete implementation of the Parser class to extract messages from the user's input
 */
@Component("MessageParser")
public class MessageParser implements Parser<String, String> {

    @Autowired
    private RuleConfiguration config;

    /**
     * Extracts the message if there is any string left after the separator message found in the input
     *
     * @param input the user input
     * @return the message after the separator. Else an empty string
     */
    @Override
    public String getValue(String input) {
        int separatorIndex = input.indexOf(config.getSeparator());

        if (separatorIndex == input.length() - 1 || separatorIndex == -1) {
            return "";
        }

        return input.substring(separatorIndex + 1);
    }
}