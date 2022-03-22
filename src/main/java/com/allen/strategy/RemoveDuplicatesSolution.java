package com.allen.strategy;

/**
 * @author Allen
 * @date 2022/3/21 16:09
 */
public class RemoveDuplicatesSolution extends AbstractDuplicatesSolutionStrategy {

    public RemoveDuplicatesSolution(int consecutiveLength) {
        super(consecutiveLength);
    }

    /**
     * Remove consecutive identical characters with regex until
     * there is no more than {@code consecutiveLength} identical characters sitting besides each other.
     *
     * @param lowercase Must be lowercase string
     * @return After processing string, it can be empty but not null
     */
    @Override
    public String solution(String lowercase) {
        int length = lowercase.length();

        while (true) {
            lowercase = lowercase.replaceFirst(consecutiveRegex, "");
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
