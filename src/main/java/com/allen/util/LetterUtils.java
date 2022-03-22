package com.allen.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Utility methods for handling {@link String} and {@code char}.
 *
 * @author Allen
 * @date 2022/3/21 16:22
 */
public class LetterUtils {

    /**
     * Verify whether the {@code lowercase} is lowercase.
     * If not, an {@link AssertionError} is thrown
     *
     * @param lowercase Must be lowercase string
     */
    public static void verifyLowercase(String lowercase) {
        assert lowercase != null && Pattern.matches("[a-z]+", lowercase);
    }

    /**
     * Gets a single character that comes before {@code sourceChar} alphabetically, return as a String.
     * If {@code sourceChar} is less than or equal to char 'a' or greater than char 'z', it returns empty.
     *
     * @param sourceChar lowercase
     * @return Returns before character as a string, or empty.
     */
    public static String getLowercaseBefore(char sourceChar) {
        if (sourceChar <= 'a' || sourceChar > 'z') {
            return "";
        } else {
            return String.valueOf((char) (sourceChar - 1));
        }
    }

    /**
     * Get {@code source} start index with regex.
     *
     * @param regex Regex to mache {@code source}.
     * @param source The string to be matched.
     * @return The start index matched by {@code regex}, or default value -1.
     */
    public static int getStartByRegex(String regex, String source) {
        assert source != null && regex != null ;
        int start =  -1;
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(source);
        boolean findResult = matcher.find();
        try {
            if (findResult) {
                start = matcher.start();
            }
        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());
        }
        return start;
    }

}
