package com.luffy.design_pattern.visit;

import com.luffy.design_pattern.visit.factory.ResourceFileType;
import com.luffy.design_pattern.visit.visitor.IVistor;

/**
 * @author sunzhangfei
 * @since 2022/8/24 6:32 下午
 */
public class DocFile extends SourceFile {
    public DocFile(String filePath) {
        super(filePath);
    }

    @Override
    public ResourceFileType getFileType() {
        return ResourceFileType.DOC;
    }

    @Override
    public void accept(IVistor visitor) {
        visitor.visit(this);
    }

//
//    @Override
//    void extract2Txt() {
//        //执行转换为txt操作
//        Logutil.d("doc转化为txt");
//    }
//
//    @Override
//    void zip() {
//        Logutil.d("doc转化为zip");
//    }
}
