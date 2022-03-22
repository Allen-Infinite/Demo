package com.allen.util;

import com.allen.strategy.DuplicatesSolutionStrategy;

/**
 * Enum for {@link DuplicatesSolutionStrategy} subclass.
 *
 * @author Allen
 * @date 2022/3/21 16:13
 */
public enum DuplicatesSolutionEnum {

    /**
     * Context key to get RemoveDuplicatesSolution
     */
    REMOVE("remove", "RemoveDuplicatesSolution"),

    /**
     * Context key to get RePlaceDuplicatesSolution
     */
    REPLACE("replace", "RePlaceDuplicatesSolution");

    private String code;

    private String desc;

    DuplicatesSolutionEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public String getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }
}
