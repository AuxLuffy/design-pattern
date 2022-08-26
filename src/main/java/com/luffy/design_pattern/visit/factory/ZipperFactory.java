package com.luffy.design_pattern.visit.factory;

import com.luffy.design_pattern.visit.factory.zip.*;
import org.checkerframework.checker.units.qual.A;

import java.util.HashMap;
import java.util.Map;

/**
 * @author sunzhangfei
 * @since 2022/8/25 2:18 下午
 */
public class ZipperFactory {
    private static Map<ResourceFileType, IZip> map = new HashMap<>();

    static {
        map.put(ResourceFileType.DOC, new DocZipper());
        map.put(ResourceFileType.PDF, new PdfZipper());
        map.put(ResourceFileType.PPT, new PptZipper());
        map.put(ResourceFileType.EXCEL, new ExcelZipper());
    }

    public static IZip getZipper(ResourceFileType type) {
        return map.get(type);
    }
}
