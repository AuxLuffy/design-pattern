package com.luffy.design_pattern.command;

/**
 * @author sunzhangfei
 * @since 2022/8/31 3:19 下午
 */
public class GotStarCommand implements Command {
    /**
     * 命令所需要的数据
     */
    private Object data;

    public GotStarCommand(Object data) {
        this.data = data;
    }

    @Override
    public void excute() {

    }
}
