package com.luffy.design_pattern.command;

/**
 * @author sunzhangfei
 * @since 2022/8/31 3:08 下午
 */
public class Request {
    private Event event;
    private Object data;

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
