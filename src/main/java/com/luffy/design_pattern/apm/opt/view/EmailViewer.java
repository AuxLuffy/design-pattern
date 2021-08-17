package com.luffy.design_pattern.apm.opt.view;

import com.luffy.design_pattern.apm.opt.bean.RequestStat;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * desc: email输出类
 *
 * @author luffy
 * @since 2021/8/17 23:17
 */
public class EmailViewer implements IStatViewer {
    private EmailSender emailSender;

    private List<String> toAddresses = new ArrayList<>();

    public EmailViewer() {
        this.emailSender = new EmailSender();
    }

    public void addToAddress(String address) {
        toAddresses.add(address);
    }

    @Override
    public void output(Map<String, RequestStat> requestStats, long startTimeMillis, long endTimeMillis) {
        // format the requestStats to HTML style.
        // send it to email toAddresses.
    }
}
