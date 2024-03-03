package com.beta.replyservice.services.parsers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RuleParser implements Parser<Integer, String> {

    @Autowired
    private String ruleMessageSeparator;

    @Override
    public Integer getValue(String input) {
        int separatorIndex = input.indexOf(ruleMessageSeparator);

        return Integer.parseInt(input.substring(0, separatorIndex));
    }
}
