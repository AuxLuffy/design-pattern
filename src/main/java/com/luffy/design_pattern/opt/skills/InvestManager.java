package com.luffy.design_pattern.opt.skills;

import java.util.Calendar;
import java.util.Date;

/**
 * 投资管理
 *
 * @author sunzhangfei
 * @since 2021/8/10 6:53 下午
 */
public class InvestManager {
    /**
     * 投资
     * 重构前代码
     *
     * @param userId             用户id
     * @param financialProductId 金融产品id
     */
    public void invest(long userId, long financialProductId) {
        Calendar calendar = Calendar.getInstance();
        Date date = new Date();
        calendar.setTime(date);
        calendar.set(Calendar.DATE, calendar.get(Calendar.DATE) + 1);
        if (calendar.get(Calendar.DAY_OF_MONTH) == 1) {
            return;
        }
        //。。。
    }

    /**
     * 投资
     * 重构后代码
     * 将判断条件抽成方法，将代码分隔成更小的单元块
     *
     * @param userId             用户id
     * @param financialProductId 金融产品id
     */
    public void investOpt(long userId, long financialProductId) {
        if (isLastDayOfMonth()) {
            return;
        }
        //。。。
    }

    /**
     * 是否是当月的最后一天
     *
     * @return
     */
    private boolean isLastDayOfMonth() {
        Calendar calendar = Calendar.getInstance();
        Date date = new Date();
        calendar.setTime(date);
        calendar.set(Calendar.DATE, calendar.get(Calendar.DATE) + 1);
        return calendar.get(Calendar.DAY_OF_MONTH) == 1;
    }
}