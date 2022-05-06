package com.luffy.design_pattern.id;

/**
 * @author sunzhangfei
 * @since 2021/8/17 4:59 下午
 */
class IdGenerationFailureException extends RuntimeException {
    public IdGenerationFailureException() {
    }

    public IdGenerationFailureException(String s) {
        super(s);
    }
}