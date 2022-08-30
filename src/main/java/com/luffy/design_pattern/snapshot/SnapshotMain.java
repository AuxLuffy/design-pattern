package com.luffy.design_pattern.snapshot;

import java.util.Scanner;

/**
 * 快照/备忘录模式 Memonto Design pattern
 *
 * @author sunzhangfei
 * @since 2022/8/26 6:54 下午
 */
public class SnapshotMain {
    public static void main(String[] args) {
        InputText inputText = new InputText();
        SnapShotHolder snapshot = new SnapShotHolder();
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String input = scanner.next();
            if (input.equals(":list")) {
                System.out.println(inputText.toString());
            } else if (input.equals(":undo")) {
                SnapShotHolder.SnapShot ss = snapshot.popSnapshot();
                inputText.restoreSnapShot(ss);
            } else {
                SnapShotHolder.SnapShot snapShot = new SnapShotHolder.SnapShot(inputText.toString());
                snapshot.pushSnapshot(snapShot);
                inputText.append(input);
            }
        }
    }
}
