package com.luffy.design_pattern.snapshot;

/**
 * 输入的对象
 *
 * @author sunzhangfei
 * @since 2022/8/29 10:47 上午
 */
public class InputText {
    private StringBuilder text = new StringBuilder();

    public void restoreSnapShot(SnapShotHolder.SnapShot snapShot) {
        this.text.replace(0, this.text.length(), snapShot.getText());
    }

    @Override
    public String toString() {
        return text.toString();
    }

    public void append(String input) {
        this.text.append(input);
    }
}
