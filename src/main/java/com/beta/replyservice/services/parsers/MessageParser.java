package com.beta.replyservice.services.parsers;

import org.springframework.stereotype.Service;

@Service
public class MessageParser implements Parser<String, String> {

    private static final String SEPARATOR = "-"; //TODO: put in prop file

    @Override
    public String getValue(String input) {
        int separatorIndex = input.indexOf(SEPARATOR);

        return input.substring(separatorIndex + 1);
    }
}
