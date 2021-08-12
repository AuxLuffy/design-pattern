package com.luffy.design_pattern.ioc.di;

/**
 * 推送商品促销，验证码等消息给用户
 *
 * @author sunzhangfei
 * @since 2021/8/4 11:10 上午
 */
public class MessageSender implements ISender {
    @Override
    public void send(String phone, String message) {
        //...
        System.out.println("具体实现，发送消息给" + phone + ": " + message);
    }
}