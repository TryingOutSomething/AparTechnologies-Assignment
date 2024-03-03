package com.beta.replyservice.services.operations;

class ReverseStringOperation implements Operation<String> {

    @Override
    public String execute(String value) {
        if (value == null) {
            return null;
        }

        return new StringBuilder(value).reverse().toString();
    }
}
