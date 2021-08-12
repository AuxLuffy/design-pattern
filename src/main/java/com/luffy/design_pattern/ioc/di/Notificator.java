package com.luffy.design_pattern.ioc.di;

/**
 * 消息推送
 * 依赖Message sender实现推送商品促销、验证码等消息给用户
 *
 * @author sunzhangfei
 * @since 2021/8/4 11:10 上午
 */
public class Notificator {
    private final ISender sender;

    public Notificator(ISender sender) {
        this.sender = new MessageSender();
    }

    public void sendMessage(String phone, String message) {
        //...校验逻辑省略...
        System.out.println("校验手机号和消息通过");
        this.sender.send(phone, message);
    }

    public static void main(String[] args) {
        Notificator notificator = new Notificator(new MessageSender());
        notificator.sendMessage("110", "help!");
    }
}