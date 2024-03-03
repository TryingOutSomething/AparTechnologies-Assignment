package com.beta.replyservice.services.operations;

import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@Service
public class RuleBasedOperation implements IRuleBasedOperation {

    private static final Map<Integer, Operation<String>> ruleOperationsMap;
    private static final int REVERSE_STRING_KEY = 1;
    private static final int HASH_STRING_KEY = 2;

    static {
        final Map<Integer, Operation<String>> map = new HashMap<>();

        populateRules(map);

        ruleOperationsMap = Collections.unmodifiableMap(map);
    }

    private static void populateRules(Map<Integer, Operation<String>> map) {
        map.put(REVERSE_STRING_KEY, new ReverseStringOperation());
        map.put(HASH_STRING_KEY, new MD5HashedStringOperation());
    }

    public String processRuleBasedOperation(String rules, String message) {
        char DIGIT_OFFSET_CHAR = '0';
        String processedMessage = message;

        int consecutiveRuleOneFrequency = 0;

        for (int i = 0; i < rules.length(); i++) {
            int currentRule = rules.charAt(i) - DIGIT_OFFSET_CHAR;

            if (currentRule == 1) {
                consecutiveRuleOneFrequency++;
                continue;
            }

            // Reversing a string twice negates the reversal process.
            // If we encounter an odd number of repeating rule one operation, we require only one string reversal operation
            if (consecutiveRuleOneFrequency % 2 == 1) {
                processedMessage = ruleOperationsMap.get(REVERSE_STRING_KEY).execute(processedMessage);
                consecutiveRuleOneFrequency = 0;
            }

            processedMessage = ruleOperationsMap.get(HASH_STRING_KEY).execute(processedMessage);
        }

        if (consecutiveRuleOneFrequency % 2 == 1) {
            processedMessage = ruleOperationsMap.get(REVERSE_STRING_KEY).execute(processedMessage);
        }

        return processedMessage;
    }
}
