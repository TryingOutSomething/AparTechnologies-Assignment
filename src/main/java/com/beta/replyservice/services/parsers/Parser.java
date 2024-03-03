package com.beta.replyservice.services.parsers;

public interface Parser<L, R> {

    L getValue(R value);
}
