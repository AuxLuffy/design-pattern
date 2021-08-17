package com.luffy.design_pattern.opt.skills;

/**
 * 单元测试
 *
 * @author sunzhangfei
 * @since 2021/8/10 2:11 下午
 */
public class Text {
    private String content;

    public Text(String content) {
        this.content = content;
    }

    public Integer toNumber() {
        if (content == null || content.isEmpty()) {
            return null;
        }
        String temp = content.trim();
        try {
            int i = Integer.parseInt(temp);
            return i;
        } catch (Exception e) {
        }
        return null;
    }

    public class ClassName {
        public void foo() {
            // method body
        }
    }
}