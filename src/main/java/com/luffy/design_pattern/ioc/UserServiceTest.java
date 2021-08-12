package com.luffy.design_pattern.ioc;

/**
 * 什么是IOC，控制反转
 * 这是一个测试类，用来实现测试代码的功能
 * 此时所有的测试代码都要写在这个类里面
 *
 * @author sunzhangfei
 * @since 2021/8/3 7:09 下午
 */
public class UserServiceTest {
    public static boolean doTest() {
        boolean result = false;
        //...
        return result;
    }

    public static void main(String[] args) {
        if (doTest()) {
            System.out.println("Test success.");
        } else {
            System.out.println("Test failed.");
        }
    }
}