package com.beta.replyservice;

import com.beta.replyservice.services.operations.IRuleBasedOperation;
import com.beta.replyservice.services.parsers.Parser;
import com.beta.replyservice.services.validation.ValidationResult;
import com.beta.replyservice.services.validation.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("ReplyControllerV2")
@RequestMapping("v2/")
public class ReplyControllerV2 {

    @Autowired
    private Validator validator;
    @Autowired
    @Qualifier("RuleParser")
    private Parser<String, String> ruleParser;
    @Autowired
    @Qualifier("MessageParser")
    private Parser<String, String> messageParser;
    @Autowired
    private IRuleBasedOperation ruleBasedOperation;

    /**
     * Informs the user that the message is empty
     *
     * @return the response entity
     */
    @GetMapping("/reply")
    public ResponseEntity<ReplyMessage> replying() {
        return new ResponseEntity<>(new ReplyMessage("Message is empty"), HttpStatus.BAD_REQUEST);
    }

    /**
     * Validates and processes the user provided message
     *
     * @param message the message
     * @return the response entity
     */
    @GetMapping("/reply/{message}")
    public ResponseEntity<ReplyMessage> replying(@PathVariable String message) {
        String reply;
        HttpStatus status;

        final ValidationResult result = validator.isValidInput(message);

        if (!result.isValid()) {
            reply = result.getErrorMessage();
            status = HttpStatus.BAD_REQUEST;
        } else {
            String rules = ruleParser.getValue(message);
            String userMessage = messageParser.getValue(message);

            reply = ruleBasedOperation.processRuleBasedOperation(rules, userMessage);
            status = HttpStatus.OK;
        }

        return new ResponseEntity<>(new ReplyMessage(reply), status);
    }
}