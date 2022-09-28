package com.luffy.design_pattern.command;

/**
 * @author sunzhangfei
 * @since 2022/8/31 2:23 下午
 */
public class GotDiamondCommand implements Command {
    /**
     * 命令所需要的数据
     */
    private Object data;

    public GotDiamondCommand(Object data) {
        this.data = data;
    }

    @Override
    public void excute() {
        //执行相应的逻辑
    }
}
