package com.beta.replyservice.parsers;

import com.beta.replyservice.services.parsers.Parser;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class RuleParserTest {

    // TESTS ASSUMES THAT ALL RULES IN INPUT ARE 1 AND 2
    @Autowired
    @Qualifier("RuleParser")
    private Parser<String, String> ruleParser;

    @Test
    public void testAreValidRules() {
        String input = "12-njasdjasn";

        String expectedResult = input.split("-")[0];
        String actualResult = ruleParser.getValue(input);

        Assertions.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testAreDistinctRules() {
        String input = "11222121222222221-njasdjasn";

        String expectedResult = "1212121";
        String actualResult = ruleParser.getValue(input);

        Assertions.assertEquals(expectedResult, actualResult);
    }
}
