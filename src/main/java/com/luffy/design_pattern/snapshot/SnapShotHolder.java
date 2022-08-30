package com.luffy.design_pattern.snapshot;

import java.util.Stack;

/**
 * 快照的容器类
 * 如果要备份的数据比较大就要考虑备份增量或者考虑增量全量两种策略增加步长来备份（即，每过n次备份一次全量，中间备份增量）
 *
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
