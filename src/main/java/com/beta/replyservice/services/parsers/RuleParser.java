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

        return removeDuplicateCharactersInRules(input.substring(0, separatorIndex));
    }

    private String removeDuplicateCharactersInRules(String rules) {
        if (rules.length() < 2) {
            return rules;
        }

        StringBuilder sb = new StringBuilder();
        int i = 0;
        int j = 1;

        while (j < rules.length()) {
            char previousSameCharacter = rules.charAt(i);
            char currentCharacter = rules.charAt(j);

            if (currentCharacter != previousSameCharacter) {
                sb.append(previousSameCharacter);
                i = j;
            }

            j++;
        }

        sb.append(rules.charAt(i)); // need to append the last character if it is unique to the 2nd last character

        return sb.toString();
    }
}
