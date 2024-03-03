package com.beta.replyservice.services.operations;

public interface Operation<T> {
    T execute(T value);
}
