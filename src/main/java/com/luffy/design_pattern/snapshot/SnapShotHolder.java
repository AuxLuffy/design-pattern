package com.luffy.design_pattern.snapshot;

import java.util.Stack;

/**
 * @author sunzhangfei
 * @since 2022/8/29 11:32 上午
 */
public class SnapShotHolder {
    //复用inputtext的数据结构不对，因为inputtext类对外暴露了settext方法，这样会导致快照会被意外修改，快照应该设计成不可变的，所以再加一个快照类
    private Stack<SnapShot> snapShots = new Stack<>();

    public SnapShot popSnapshot() {
        return snapShots.pop();
    }

    public void pushSnapshot(SnapShot snapShot) {
        snapShots.push(snapShot);
    }

    public static class SnapShot {
        private String text;

        public SnapShot(String text) {
            this.text = text;
        }

        public String getText() {
            return text;
        }
    }
}
