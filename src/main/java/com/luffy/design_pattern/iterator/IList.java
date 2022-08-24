package com.luffy.design_pattern.iterator;

/**
 * @author sunzhangfei
 * @since 2022/8/24 3:55 下午
 */
public interface IList<E> {
    void add(E element);
    void remove(E element);
    Iterator<E> iterator();

    int size();

    E get(int cursor);
}
