package com.beta.replyservice.validation;

import com.beta.replyservice.configuration.RequestErrorMessage;
import com.beta.replyservice.services.validation.ValidationResult;
import com.beta.replyservice.services.validation.Validator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class RequestPayloadValidatorTest {

    @Autowired
    private Validator validator;

    @Autowired
    private RequestErrorMessage requestErrorMessage;

    @Test
    public void testIsValidUserInput() {
        String input = "1-skdaskdmskdm";

        boolean expectedResult = false;
        boolean actualResult = validator.isValidInput(input).isValid();

        Assertions.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testIsInvalidRuleNotNumericInput() {
        String input = "1a-skdaskdmskdm";

        ValidationResult result = validator.isValidInput(input);

        boolean expectedResult = false;
        boolean actualValidationResult = result.isValid();

        Assertions.assertEquals(expectedResult, actualValidationResult);

        String expectedErrorMessage = requestErrorMessage.getPrefix() + " " +
                requestErrorMessage.getInvalidRule() +
                requestErrorMessage.getRuleNotNumeric();
        Assertions.assertEquals(expectedErrorMessage, result.getErrorMessage());
    }

    @Test
    public void testIsInvalidRuleNotWhitelistedInput() {
        String input = "55-skdaskdmskdm";

        ValidationResult result = validator.isValidInput(input);

        boolean expectedResult = false;
        boolean actualValidationResult = result.isValid();

        Assertions.assertEquals(expectedResult, actualValidationResult);

        String expectedErrorMessage = requestErrorMessage.getPrefix() + " " +
                requestErrorMessage.getInvalidRule() +
                requestErrorMessage.getRuleNotWhitelisted() + " For 5";
        Assertions.assertEquals(expectedErrorMessage, result.getErrorMessage());
    }

    @Test
    public void testIsInvalidMessageInput() {
        String input = "1-";

        boolean expectedResult = false;
        boolean actualResult = validator.isValidInput(input).isValid();

        Assertions.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testEmptyMessageInput() {
        String input = "";

        boolean expectedResult = false;
        boolean actualResult = validator.isValidInput(input).isValid();

        Assertions.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testNullMessageInput() {
        String input = "";

        boolean expectedResult = false;
        boolean actualResult = validator.isValidInput(input).isValid();

        Assertions.assertEquals(expectedResult, actualResult);
    }
}
