package com.beta.replyservice.services.operations;

/**
 * The concrete implementation of the Operation interface.
 */
class ReverseStringOperation implements Operation<String> {

    /**
     * Performs a reverse string operation on the user provided message.
     *
     * @param value the message to reverse
     */
    @Override
    public String execute(String value) {
        if (value == null) {
            return null;
        }

        return new StringBuilder(value).reverse().toString();
    }
}
