package com.beta.replyservice.services.operations;

import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@Service
public class RuleBasedOperation implements IRuleBasedOperation {

    private static final Map<Integer, Operation<String>> ruleOperationsMap;

    static {
        final Map<Integer, Operation<String>> map = new HashMap<>();

        populateRules(map);

        ruleOperationsMap = Collections.unmodifiableMap(map);
    }

    private static void populateRules(Map<Integer, Operation<String>> map) {
        map.put(1, new ReverseStringOperation());
        map.put(2, new MD5HashedStringOperation());
    }

    public String processRuleBasedOperation(int rule, String message) {
        if (!ruleOperationsMap.containsKey(rule)) {
            throw new RuntimeException("Invalid rule!");
        }

        return ruleOperationsMap.get(rule).execute(message);
    }
}
