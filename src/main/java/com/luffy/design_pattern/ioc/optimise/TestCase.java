package com.luffy.design_pattern.ioc.optimise;

/**
 * 测试父类
 *
 * @author sunzhangfei
 * @since 2021/8/3 7:19 下午
 */
public abstract class TestCase {
    public void run() {
        if (doTest()) {
            System.out.println("Test success.");
        } else {
            System.out.println("Test failed.");
        }
    }

    /**
     * 测试代码
     */
    protected abstract boolean doTest();
}