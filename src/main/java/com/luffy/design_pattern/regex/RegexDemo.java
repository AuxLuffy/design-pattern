package com.luffy.design_pattern.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 正则表达式示例
 *
 * @author sunzhangfei
 * @since 2022/9/22 2:26 下午
 */
public class RegexDemo {
    public static void main(String[] args) {
//        testReplace();
        matchTest();
    }

    private static void testReplace() {
        final String regex = "(\\.\\d\\d(?>[1-9]?))\\d+";
        final String string = "15.214123、37.500232、154.356";
        final String subst = "$1";

        final Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE);
        final Matcher matcher = pattern.matcher(string);

        // The substituted value will be contained in the result variable
        final String result = matcher.replaceAll(subst);

        System.out.println("Substitution result: " + result);
    }

    private static void matchTest(){
        final String regex = "(\\.\\d\\d(?>[1-9]?))\\d+";
        final String string = "15.214123、37.500232、154.356";

        final Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE);
        final Matcher matcher = pattern.matcher(string);

        while (matcher.find()) {
            System.out.println("Full match: " + matcher.group(0));

            for (int i = 1; i <= matcher.groupCount(); i++) {
                System.out.println("Group " + i + ": " + matcher.group(i));
            }
        }
    }
}
