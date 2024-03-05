package com.beta.replyservice.services.parsers;

import com.beta.replyservice.configuration.RuleConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * The concrete implementation of the Parser class to extract rules from the user's input
 */
@Component("RuleParser")
public class RuleParser implements Parser<String, String> {

    @Autowired
    private RuleConfiguration config;

    /**
     * Extracts the rules in the input string before the separator
     *
     * @param input the user input
     * @return the rules before the separator. No extraction is done if the separator index is not found
     */
    @Override
    public String getValue(String input) {
        int separatorIndex = input.indexOf(config.getSeparator());

        if (separatorIndex == -1) {
            return input;
        }

        return input.substring(0, separatorIndex);
    }
}
