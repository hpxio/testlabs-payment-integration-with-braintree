package com.app.hpx.testlabs.integrator.utils;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Base64;

public class EncodeDecodeUtil {

    private EncodeDecodeUtil() {
        /* to avoid instantiation */
    }

    public static String encodeString(String input) {
        return Base64.getEncoder().encodeToString(input.getBytes(StandardCharsets.UTF_8));
    }

    public static String decodeString(String input) {
        byte[] decodedBytes = Base64.getDecoder().decode(input);
        return Arrays.toString(decodedBytes);
    }
}
