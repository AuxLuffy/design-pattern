package com.luffy.design_pattern.visit;

import com.luffy.design_pattern.visit.factory.ResourceFileType;
import com.luffy.design_pattern.visit.visitor.IVistor;

/**
 * @author sunzhangfei
 * @since 2022/8/24 6:33 下午
 */
public class PptFile extends SourceFile {

    public PptFile(String filePath) {
        super(filePath);
    }
    @Override
    public ResourceFileType getFileType() {
        return ResourceFileType.PPT;
    }

    @Override
    public void accept(IVistor visitor) {
        visitor.visit(this);
    }
//
//    @Override
//    void extract2Txt() {
//        //执行转换为txt操作
//        Logutil.d("ppt转化为txt");
//    }
}
