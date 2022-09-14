package com.luffy.design_pattern.templatepattern;

/**
 * desc: J
 *
 * @author luffy
 * @since 2022/8/13 1:07
 */
public class ShutdownHookDemo {
    public static void main(String[] args) {
        Runtime.getRuntime().addShutdownHook(new ShutDownHook());
//        System.out.println("slak");
    }

    private static class ShutDownHook extends Thread {
        @Override
        public void run() {
            System.out.println("I am called during shutting down.");
        }
    }
}
