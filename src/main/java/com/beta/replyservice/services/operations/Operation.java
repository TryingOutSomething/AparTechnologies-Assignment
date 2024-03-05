package com.beta.replyservice.services.operations;

/**
 * The interface Operation. Each operation must implement this class to be used in the app
 *
 * @param <T> the type parameter
 */
public interface Operation<T> {
    T execute(T value);
}
