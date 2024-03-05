package com.beta.replyservice.services.parsers;


/**
 * The interface Parser.
 *
 * @param <L> the return type
 * @param <R> the type parameter
 */
public interface Parser<L, R> {
    L getValue(R value);
}
