package com.luffy.design_pattern.stragedy;

/**
 * 程序入口
 *
 * @author sunzhangfei
 * @since 2022/9/28 4:39 下午
 */
public class Application {
    public static void main(String[] args) {
        Sorter sorter = new Sorter();
        String path = "/Users/sunzhangfei/Documents/learn/pattern-design/testdata/numbers.txt";
        sorter.sort(path);
    }
}
