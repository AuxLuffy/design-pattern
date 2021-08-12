package com.luffy.design_pattern.opt.refractor;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author sunzhangfei
 * @since 2021/8/12 3:55 下午
 */
public class TestIdGenerator {
    public void testGetLastFieldOfhostName() {

    }

    @Test
    public void testGetLastSubstrSplitByDot() {
        RandomIdGenerator idGenerator = new RandomIdGenerator();
        String substrSplitByDot = idGenerator.getLastSubstrSplitByDot("field1.field2.field3");
        assertEquals("field3", substrSplitByDot);
    }
}