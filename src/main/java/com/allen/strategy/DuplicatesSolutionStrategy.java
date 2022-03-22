package com.allen.strategy;

/**
 * Strategy interface defined to handle consecutive identical characters
 *
 * @author Allen
 * @date 2022/3/21 16:04
 */
public interface DuplicatesSolutionStrategy {

    /**
     * Method defined to handle consecutive identical characters
     *
     * @param lowercase Must be lowercase string
     * @return After processing string, it can be empty but not null
     */
    String handle(String lowercase);

}
