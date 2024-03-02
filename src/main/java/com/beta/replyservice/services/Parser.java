package com.beta.replyservice.services;

public interface Parser<L, R> {

    L getValue(R value);
}
