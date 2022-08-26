package com.luffy.design_pattern.visit;

import com.luffy.design_pattern.visit.visitor.Extractor;
import com.luffy.design_pattern.visit.visitor.IVistor;
import com.luffy.design_pattern.visit.visitor.Visitor;
import com.luffy.design_pattern.visit.visitor.Zipper;

import java.util.ArrayList;
import java.util.List;

/**
 * 访问者模式
 *
 * @author sunzhangfei
 * @since 2022/8/24 6:28 下午
 */
public class MainProcessor {
    public static void main(String[] args) {
        List<SourceFile> files = getFiles();
        IVistor extractor = new Extractor();
        IVistor zipper = new Zipper();
        for (SourceFile file : files) {
            file.accept(extractor);
            file.accept(zipper);
        }
    }

    private static List<SourceFile> getFiles() {
        ArrayList<SourceFile> sourceFiles = new ArrayList<>();
        sourceFiles.add(new DocFile("a.doc"));
        sourceFiles.add(new PdfFile("b.pdf"));
        sourceFiles.add(new PptFile("c.ppt"));
        return sourceFiles;
    }


}
