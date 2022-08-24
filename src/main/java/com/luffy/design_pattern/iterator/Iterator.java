package com.luffy.design_pattern.iterator;

/**
 * @author sunzhangfei
 * @since 2022/8/24 3:54 下午
 */
public interface Iterator<E> {
    boolean hasNext();
    void next();
    E currentItem();
}
