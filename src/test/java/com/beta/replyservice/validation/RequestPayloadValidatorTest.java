package com.beta.replyservice.validation;

import com.beta.replyservice.services.validation.Validator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class RequestPayloadValidatorTest {

    @Autowired
    Validator validator;

    @Test
    public void testIsValidUserInput() {
        String input = "1-skdaskdmskdm";

        boolean expectedResult = true;
        boolean actualResult = validator.isValidInput(input);

        Assertions.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testIsInvalidRuleInput() {
        String input = "a-skdaskdmskdm";

        boolean expectedResult = false;
        boolean actualResult = validator.isValidInput(input);

        Assertions.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testIsInvalidMessageInput() {
        String input = "1-";

        boolean expectedResult = false;
        boolean actualResult = validator.isValidInput(input);

        Assertions.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testEmptyMessageInput() {
        String input = "";

        boolean expectedResult = false;
        boolean actualResult = validator.isValidInput(input);

        Assertions.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testNullMessageInput() {
        String input = "";

        boolean expectedResult = false;
        boolean actualResult = validator.isValidInput(input);

        Assertions.assertEquals(expectedResult, actualResult);
    }
}
