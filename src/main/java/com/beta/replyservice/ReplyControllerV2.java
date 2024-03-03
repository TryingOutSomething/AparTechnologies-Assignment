package com.beta.replyservice;

import com.beta.replyservice.services.operations.IRuleBasedOperation;
import com.beta.replyservice.services.parsers.Parser;
import com.beta.replyservice.services.validation.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("ReplyControllerV2")
@RequestMapping("v2/")
public class ReplyControllerV2 extends ReplyController {

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

    @Override
    // base path: /reply
    public ReplyMessage replying() {
        return new ReplyMessage("test");
    }

    @Override
    // base path: /reply/{message}
    public ReplyMessage replying(@PathVariable String message) {
        String reply;

        if (!validator.isValidInput(message)) {
            reply = "Invalid input";
        } else {
            String rules = ruleParser.getValue(message);
            String userMessage = messageParser.getValue(message);

            reply = ruleBasedOperation.processRuleBasedOperation(rules, userMessage);
        }

        return new ReplyMessage(reply);
    }
}
