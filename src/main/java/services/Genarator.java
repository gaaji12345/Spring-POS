package services;/*  gaajiCode
    99
    23/08/2024
    */

import org.springframework.stereotype.Component;

import java.security.SecureRandom;
import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class Genarator {
    private static final SecureRandom random = new SecureRandom();
    private static final String ALPHANUMERIC = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
   // int x=1;


    // Generates a random order ID of specified length
//    public static String generateOrderId(int length) {
//        StringBuilder sb = new StringBuilder(length);
//        for (int i = 0; i < length; i++) {
//            int index = random.nextInt(ALPHANUMERIC.length());
//            sb.append(ALPHANUMERIC.charAt(index));
//        }
//        return sb.toString();
//    }

//    public static String generateOrderId(int length, String prefix, String suffix) {
//        StringBuilder sb = new StringBuilder(prefix);
//        for (int i = 0; i < length; i++) {
//            int index = random.nextInt(ALPHANUMERIC.length());
//            sb.append(ALPHANUMERIC.charAt(index));
//        }
//        sb.append(suffix);
//        return sb.toString();
//    }

    public static String generateOrderId(int length, String prefix, String suffix, boolean includeTimestamp) {
        StringBuilder sb = new StringBuilder();

        // Optionally include timestamp
        if (includeTimestamp) {
            String timestamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
            sb.append(timestamp);
        }

        // Append prefix
        if (prefix != null && !prefix.isEmpty()) {
            sb.append(prefix);
        }

        // Generate random characters
        for (int i = 0; i < length; i++) {
            int index = random.nextInt(ALPHANUMERIC.length());
            sb.append(ALPHANUMERIC.charAt(index));
        }

        // Append suffix
        if (suffix != null && !suffix.isEmpty()) {
            sb.append(suffix);
        }

        return sb.toString();
    }

    // Convenience method for a simple order ID with no prefix or suffix
    public static String generateSimpleOrderId(int length) {
        return generateOrderId(length, null, null, false);
    }
}
