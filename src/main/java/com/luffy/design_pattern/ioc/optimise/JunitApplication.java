package com.luffy.design_pattern.ioc.optimise;

import java.util.ArrayList;
import java.util.List;

/**
 * ioc inversion of control
 * 优化的简单测试框架
 * 之前的测试代码编写的时候需要各种代码都在主程序里写，现在可以改为通过注入的方式自动运行相关类的方式写测试代码
 *
 * @author sunzhangfei
 * @since 2021/8/3 7:16 下午
 */
public class JunitApplication {
    private static final List<TestCase> testCases = new ArrayList<>();

    public static void register(TestCase testCase) {
        testCases.add(testCase);
    }

    public static void main(String[] args) {
        for (TestCase testCase : testCases) {
            testCase.run();
        }
    }

}