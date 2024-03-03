package com.beta.replyservice.services.parsers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("RuleParser")
public class RuleParser implements Parser<String, String> {

    @Autowired
    private String ruleMessageSeparator;

    @Override
    public String getValue(String input) {
        int separatorIndex = input.indexOf(ruleMessageSeparator);

        if (separatorIndex == -1) {
            return input;
        }

        return input.substring(0, separatorIndex);
    }
}
