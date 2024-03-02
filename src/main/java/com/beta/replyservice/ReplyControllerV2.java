package com.beta.replyservice;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("ReplyControllerV2")
@RequestMapping("v2/")
public class ReplyControllerV2 extends ReplyController {

    @Override
    // base path: /reply
    public ReplyMessage replying() {
        return new ReplyMessage("test");
    }

    @Override
    // base path: /reply/{message}
    public ReplyMessage replying(@PathVariable String message) {
        return new ReplyMessage("v2: " + message);
    }
}
