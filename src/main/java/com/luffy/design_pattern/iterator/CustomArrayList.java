package com.luffy.design_pattern.iterator;

/**
 * @author sunzhangfei
 * @since 2022/8/24 3:57 下午
 */
public class CustomArrayList<E> implements IList<E> {
    Object[] elements;
    private static final int INITIAL_DEFAULT_SIZE = 8;
    public CustomArrayList() {
        elements = new Object[INITIAL_DEFAULT_SIZE];
    }

    @Override
    public void add(E element) {

    }

    @Override
    public void remove(E element) {

    }

    @Override
    public Iterator<E> iterator() {
        return new ArrayIterator<>(this);
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public E get(int cursor) {
        return null;
    }
}
