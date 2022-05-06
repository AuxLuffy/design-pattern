package com.luffy.design_pattern.test;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author sunzhangfei
 * @since 2021/7/19 7:35 下午
 */
public class Double2IntTest {
    public static void main(String[] args) {
//        testDouble2Int();
        testFutureTask();
    }

    private static void testDouble2Int() {
        for (int i = 0; i < 1000000000; i++) {
            double d = 84.31661555148575D;
            int in = (int) (d);
            if (in != 84) {
                throw new IllegalArgumentException("大于了84： " + in);
            }
        }
        System.out.println(Integer.MAX_VALUE);
    }


    public static class CallableTask implements Callable<String> {

        @Override
        public String call() throws Exception {
            return "hello";
        }
    }

    /**
     * futureTask类测试
     */
    public static void testFutureTask() {
        FutureTask<String> task = new FutureTask<>(new CallableTask());
        new Thread(task).start();
        try {
            String s = task.get();
            System.out.println(s);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}