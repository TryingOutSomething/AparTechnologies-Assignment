package com.beta.replyservice.services.operations;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * The concrete implementation of the Operation interface.
 */
class MD5HashedStringOperation implements Operation<String> {

    private static final String ALGO = "MD5";

    /**
     * Performs a MD5 hash to the user provided message
     *
     * @param value the message to hash
     */
    @Override
    public String execute(String value) {
        if (value == null) {
            return null;
        }

        MessageDigest messageDigest;

        try {
            messageDigest = MessageDigest.getInstance(ALGO);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }

        messageDigest.update(value.getBytes(StandardCharsets.UTF_8));
        final BigInteger digest = new BigInteger(1, messageDigest.digest());

        return String.format("%032x", digest); // pad 32 zeros to the string
    }
}
