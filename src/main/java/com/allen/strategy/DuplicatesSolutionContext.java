package com.allen.strategy;

import com.allen.util.DuplicatesSolutionEnum;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Context to management {@link DuplicatesSolutionStrategy} instance.
 *
 * @author Allen
 * @date 2022/3/21 16:15
 */
public class DuplicatesSolutionContext {

    /**
     * {@link DuplicatesSolutionStrategy} instance holder.
     */
    private static final Map<String, DuplicatesSolutionStrategy> SOLUTION_STRATEGY_MAP = new ConcurrentHashMap<>(2);

    private static final int  CONSECUTIVE_LENGTH = 3;

    /*
      Init {@link DuplicatesSolutionStrategy} instance holder.
      In Spring project, it can be replaced with injection.
     */
    static {
        SOLUTION_STRATEGY_MAP.put(DuplicatesSolutionEnum.REMOVE.getCode(), new RemoveDuplicatesSolution(CONSECUTIVE_LENGTH));
        SOLUTION_STRATEGY_MAP.put(DuplicatesSolutionEnum.REPLACE.getCode(), new ReplaceDuplicatesSolution(CONSECUTIVE_LENGTH));
    }

    /**
     * Get {@link DuplicatesSolutionStrategy} instance by holder key.
     *
     * @param key holder key. All keys are maintained in {@link DuplicatesSolutionEnum}.
     * @return Optional<DuplicatesSolutionStrategy>
     */
    public static Optional<DuplicatesSolutionStrategy> getSolution(String key) {
        return Optional.ofNullable(SOLUTION_STRATEGY_MAP.get(key)) ;
    }

}
