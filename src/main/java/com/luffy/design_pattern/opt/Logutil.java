package com.luffy.design_pattern.opt;

import java.lang.management.ManagementFactory;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author sunzhangfei
 * @since 2021/8/11 4:10 下午
 */
public class Logutil {


    public void log(String content) {
        System.out.println(getLogHeader() + ": " + content);
    }

    private static String getLogHeader() {
        StringBuilder builder = new StringBuilder();
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        int index = 2;
        String className = stackTrace[index].getFileName();
        if (className.indexOf("Log") != -1) {
            index = 3;
            className = stackTrace[index].getFileName();
        }
        if (className.indexOf("Log") != -1) {
            index = 4;
            className = stackTrace[index].getFileName();
        }
        int lineNumber = stackTrace[index].getLineNumber();
        String methodName = stackTrace[index].getMethodName();
        builder.append(convertTimestamp2Date()).append(" " + getProcessPidNum() + "-" + Thread.currentThread().getId());
        builder.append(" [ (").append(className).append(":").append(lineNumber).append(")#").append(methodName).append(" ] ");
        return builder.toString();
    }

    /**
     * 时间戳格式转化为日期（String）
     *
     * @return
     */
    public static String convertTimestamp2Date() {

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");

        return simpleDateFormat.format(new Date());
    }

    public static String getProcessPidNum() {
        // get name representing the running Java virtual machine.
        String name = ManagementFactory.getRuntimeMXBean().getName();
        System.out.println(name);
        // get pid
        String pid = name.split("@")[0];
        return pid;
    }

}