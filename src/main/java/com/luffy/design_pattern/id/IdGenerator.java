package com.luffy.design_pattern.id;

/**
 * id生成器
 *
 * @author sunzhangfei
 * @since 2021/8/12 2:29 下午
 */
public interface IdGenerator {
    String generate() throws IdGenerationFailureException;
}
