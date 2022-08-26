package com.luffy.design_pattern.visit.factory;

import com.luffy.design_pattern.visit.factory.ResourceFileType;
import com.luffy.design_pattern.visit.factory.extractor.*;

import java.util.HashMap;
import java.util.Map;

/**
 * @author sunzhangfei
 * @since 2022/8/25 11:48 上午
 */
public class ExtractFacotory {
    private static final Map<ResourceFileType, IExtractor> extractors = new HashMap<>();
    static {
        extractors.put(ResourceFileType.DOC, new DocExtractor());
        extractors.put(ResourceFileType.PDF, new PdfExtractor());
        extractors.put(ResourceFileType.PPT, new PptExtractor());
        extractors.put(ResourceFileType.EXCEL, new ExcelExtractor());
    }
    public static IExtractor getExtractor(ResourceFileType type){
        return extractors.get(type);
    }
}
