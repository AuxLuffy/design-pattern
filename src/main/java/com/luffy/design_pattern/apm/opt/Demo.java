package com.luffy.design_pattern.apm.opt;

/**
 * 把apm运行起来
 *
 * @author sunzhangfei
 * @since 2021/8/17 8:17 下午
 */
public class Demo {
    public static void main(String[] args) {
        MetricsStorage storage = new RedisMetricsStorage();
        ConsoleReporter consoleReporter = new ConsoleReporter(storage);
        consoleReporter.startRepeatedReport(60, 60);
        EmailReporter emailReporter = new EmailReporter(storage);
        emailReporter.addToAddress("sunzhangfei@zuoyebang.com");
        emailReporter.startDailyReport();
        MetricsCollector collector = new MetricsCollector(storage);
        collector.recordRequest(new RequestInfo("register", 123L, 46363L));
        collector.recordRequest(new RequestInfo("register", 232L, 2342342L));
        collector.recordRequest(new RequestInfo("register", 12L, 12344L));
        collector.recordRequest(new RequestInfo("register", 56L, 102332L));
        collector.recordRequest(new RequestInfo("login", 231L, 102323L));
        collector.recordRequest(new RequestInfo("login", 234L, 101235L));
        collector.recordRequest(new RequestInfo("login", 236L, 1054564L));
        collector.recordRequest(new RequestInfo("login", 238L, 1758554L));
        try {
            Thread.sleep(100000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}