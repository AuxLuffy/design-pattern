package com.luffy.design_pattern.visit;

import com.luffy.design_pattern.visit.factory.ResourceFileType;
import com.luffy.design_pattern.visit.visitor.IVistor;

/**
 * @author sunzhangfei
 * @since 2022/8/24 6:29 下午
 */
public abstract class SourceFile {
    protected final String filePath;

    public SourceFile(String filePath) {
        this.filePath = filePath;
    }

    public String getFilePath() {
        return filePath;
    }

    public abstract ResourceFileType getFileType();

    public abstract void accept(IVistor visitor);

    /**
     * 转化为txt文件, 这种方式如果继续增加功能，例如压缩，提取文件信息等，就要修改所有的类，
     * 因此每个子类都会不断彭胀，可读性和可维护性就变差了，因此可以把工具类抽到一个工具类中
     * 这样就违反了开闭原则，每增加一个新功能
     */
//    abstract void extract2Txt();
//    abstract void zip();
}
