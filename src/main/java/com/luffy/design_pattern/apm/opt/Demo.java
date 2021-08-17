package com.luffy.design_pattern.apm.opt;

import com.luffy.design_pattern.apm.opt.bean.RequestInfo;
import com.luffy.design_pattern.apm.opt.collector.MetricsCollector;
import com.luffy.design_pattern.apm.opt.math.Aggregator;
import com.luffy.design_pattern.apm.opt.storage.MetricsStorage;
import com.luffy.design_pattern.apm.opt.storage.RedisMetricsStorage;
import com.luffy.design_pattern.apm.opt.view.ConsoleReporter;
import com.luffy.design_pattern.apm.opt.view.ConsoleViewer;
import com.luffy.design_pattern.apm.opt.view.EmailReporter;
import com.luffy.design_pattern.apm.opt.view.EmailViewer;

/**
 * 把apm运行起来
 *
 * @author sunzhangfei
 * @since 2021/8/17 8:17 下午
 */
public class Demo {
    public static void main(String[] args) {
        MetricsStorage storage = new RedisMetricsStorage();
        Aggregator aggregator = new Aggregator();

        ConsoleViewer consoleViewer = new ConsoleViewer();
        ConsoleReporter consoleReporter = new ConsoleReporter(storage, aggregator, consoleViewer);
        consoleReporter.startRepeatedReport(60, 60);

        EmailViewer emailViewer = new EmailViewer();
        emailViewer.addToAddress("sunzhangfei@zuoyebang.com");
        EmailReporter emailReporter = new EmailReporter(storage, aggregator, emailViewer);
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