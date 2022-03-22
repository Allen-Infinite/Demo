package com.allen.strategy;

import com.allen.util.LetterUtils;

/**
 * Abstract Strategy defined to handle consecutive identical characters
 *
 * @author Allen
 * @date 2022/3/21 18:19
 */
public abstract class AbstractDuplicatesSolutionStrategy implements DuplicatesSolutionStrategy {

    protected final String consecutiveRegex;

    protected final int consecutiveLength;

    /**
     * Create a new {@link AbstractDuplicatesSolutionStrategy} and init {@code consecutiveLength} and {@code consecutiveLength}
     *
     * @param consecutiveLength Must grater than 2
     */
    public AbstractDuplicatesSolutionStrategy(int consecutiveLength) {
        assert consecutiveLength > 2;
        this.consecutiveLength = consecutiveLength;
        this.consecutiveRegex = "(.)\\1{" + (this.consecutiveLength - 1) + ",}";
    }

    @Override
    public String handle(String lowercase) {
        System.out.printf("Input: %s%n", lowercase);

        LetterUtils.verifyLowercase(lowercase);

        System.out.printf("Output: %n");

        if (lowercase.length() < consecutiveLength) {
            System.out.printf("-> %s%n", lowercase);
            return lowercase;
        }

        return solution(lowercase);
    }

    /**
     * Method defined to handle consecutive identical characters
     *
     * @param lowercase Must be lowercase string
     * @return After processing string, it can be empty but not null
     */
    public abstract String solution(String lowercase);

}
