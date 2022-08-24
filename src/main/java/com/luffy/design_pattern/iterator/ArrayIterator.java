package com.luffy.design_pattern.iterator;

import java.util.ConcurrentModificationException;

/**
 * @author sunzhangfeiE
 * @since 2022/8/24 3:53 下午
 */
public class ArrayIterator<E> implements Iterator<E> {
    private IList<E> list;
    private int cursor;
    private int exceptedCount;

    public ArrayIterator(IList<E> list) {
        this.cursor = 0;
        this.exceptedCount = list.size();
        this.list = list;

    }

    @Override
    public boolean hasNext() {
        return cursor < exceptedCount;
    }

    private void checkModified() {
        if (exceptedCount != list.size()) {
            throw new ConcurrentModificationException();
        }
    }

    @Override
    public void next() {
        checkModified();
        cursor++;
    }

    @Override
    public E currentItem() {
        checkModified();
        return list.get(cursor);
    }
}
