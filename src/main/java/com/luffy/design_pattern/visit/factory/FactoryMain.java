package com.luffy.design_pattern.visit.factory;

import com.luffy.design_pattern.visit.*;
import com.luffy.design_pattern.visit.factory.extractor.IExtractor;
import com.luffy.design_pattern.visit.factory.zip.IZip;

import java.util.ArrayList;
import java.util.List;

/**
 * 策略模式实现同访问者模式相同的功能
 *
 * @author sunzhangfei
 * @since 2022/8/26 6:11 下午
 */
public class FactoryMain {
    public static void main(String[] args) {
        List<SourceFile> files = getFiles();
        for (int i = 0; i < files.size(); i++) {
            SourceFile file = files.get(i);
            ResourceFileType fileType = file.getFileType();
            IExtractor extractor = ExtractFacotory.getExtractor(fileType);
            if (extractor != null) {
                extractor.extract2Txt(file);
            }
            IZip zipper = ZipperFactory.getZipper(fileType);
            if (zipper != null) {
                zipper.zip(file);
            }
        }
    }


    private static List<SourceFile> getFiles() {
        ArrayList<SourceFile> sourceFiles = new ArrayList<>();
        sourceFiles.add(new DocFile("a.doc"));
        sourceFiles.add(new PdfFile("b.pdf"));
        sourceFiles.add(new PptFile("c.ppt"));
        sourceFiles.add(new ExcelFile("c.xls"));
        return sourceFiles;
    }
}
