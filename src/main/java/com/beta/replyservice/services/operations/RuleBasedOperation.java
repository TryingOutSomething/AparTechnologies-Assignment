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

    // The command pattern is used here to map rules to their operations
    static {
        final Map<Integer, Operation<String>> map = new HashMap<>();

        populateRules(map);

        ruleOperationsMap = Collections.unmodifiableMap(map);
    }

    // Register new rules and their operations here.
    // You may create a concrete implementation of the Operation here.
    // However, it is recommended to create a concrete implementation in their own java file for clarity
    // Whitelist your rules in the application.properties file via the "rules.whitelist" property to use it
    // in the app or else the validation will not accept the new rules
    private static void populateRules(Map<Integer, Operation<String>> map) {
        map.put(REVERSE_STRING_KEY, new ReverseStringOperation());
        map.put(HASH_STRING_KEY, new MD5HashedStringOperation());
    }

    @Override
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
