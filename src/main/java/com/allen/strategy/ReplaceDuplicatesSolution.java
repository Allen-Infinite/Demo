package com.allen.strategy;

import com.allen.util.LetterUtils;


/**
 * @author Allen
 * @date 2022/3/21 16:10
 */
public class ReplaceDuplicatesSolution extends AbstractDuplicatesSolutionStrategy {


    public ReplaceDuplicatesSolution(int consecutiveLength) {
        super(consecutiveLength);
    }

    /**
     * Replace consecutive identical characters with a single character that comes before it alphabetically until
     * there is no more than {@code consecutiveLength} identical characters sitting besides each other.
     *
     * @param lowercase Must be lowercase string
     * @return After processing string, it can be empty but not null
     */
    @Override
    public String solution(String lowercase) {
        int length = lowercase.length();

        while (true) {
            int start = LetterUtils.getStartByRegex(consecutiveRegex, lowercase);
            if (start < 0) {
                break;
            }

            lowercase = lowercase.replaceFirst(consecutiveRegex, LetterUtils.getLowercaseBefore(lowercase.charAt(start)));

            if (length == lowercase.length() || lowercase.length() < consecutiveLength) {
                break;
            }
            length = lowercase.length();
            System.out.printf("-> %s%n", lowercase);
        }

        System.out.printf("-> %s%n", lowercase);
        return lowercase;
    }
}
