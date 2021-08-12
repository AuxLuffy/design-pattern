package com.luffy.design_pattern.refractor.skills;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 用户管理
 * 拆分成多个函数
 * 将参数封装成对象
 * 勿用函数参数来控制逻辑
 * 函数设计要职责单一
 * 移除过深的嵌套层次
 * 学会使用解释性变量
 * <p>
 * https://hub.fastgit.org/apache/commons-lang/
 *
 * @author sunzhangfei
 * @since 2021/8/10 7:05 下午
 */
public interface IUserService {
    //修改前
    User getUser(String username, String telephone, String email);

    // 修改后：拆分成多个函数
    User getUserByUsername(String username);

    User getUserByTelephone(String telephone);

    User getUserByEmail(String email);

    class User {
    }

    //修改前
    void postBlog(String title, String summary, String keywords, String content, String category, long authorId);

    // 修改后：将参数封装成对象
    class Blog {
        private String title;
        private String summary;
        private String keywords;
        private String content;
        private String category;
        private long authorId;
    }

    void postBlog(Blog blog);

    //修改前
    void buyCourse(long userId, long courseId, boolean isVip);

    //修改后： 勿用函数参数来控制逻辑，将其拆分成两个函数
    void buyCourse(long userId, long courseId);

    void buyCourseForVip(long userId, long courseId);

    //修改前
    default boolean checkUserIfExisting(String telephone, String username, String email) {

        if (!StringUtils.isBlank(telephone)) {
            User user = null;
            //...
            return user != null;
        }

        if (!StringUtils.isBlank(username)) {
            User user = null;
            //...
            return user != null;
        }

        if (!StringUtils.isBlank(email)) {
            User user = null;
            //...
            return user != null;
        }

        return false;
    }

    // 修改后：职责要单一，拆分成三个函数
    boolean checkUserIfExistingByTelephone(String telephone);

    boolean checkUserIfExistingByUsername(String username);

    boolean checkUserIfExistingByEmail(String email);

    // 示例一
    default double caculateTotalAmount(List<Order> orders) {
        if (orders == null || orders.isEmpty()) {
            return 0.0;
        } else { // 此处的else可以去掉
            double amount = 0.0;
            for (Order order : orders) {
                if (order != null) {
                    amount += (order.getCount() * order.getPrice());
                }
            }
            return amount;
        }
    }

    // 示例二
    default List<String> matchStrings(List<String> strList, String substr) {
        List<String> matchedStrings = new ArrayList<>();
        if (strList != null && substr != null) {
            for (String str : strList) {
                if (str != null) { // 跟下面的if语句可以合并在一起
                    if (str.contains(substr)) {
                        matchedStrings.add(str);
                    }
                }
            }
        }
        return matchedStrings;
    }

    // 重构前的代码
    default List<String> matchStrings1(List<String> strList, String substr) {
        List<String> matchedStrings = new ArrayList<>();
        if (strList != null && substr != null) {
            for (String str : strList) {
                if (str != null && str.contains(substr)) {
                    matchedStrings.add(str);
                    // 此处还有10行代码...
                }
            }
        }
        return matchedStrings;
    }

    // 重构后的代码：使用continue提前退出
    default List<String> matchStrings2(List<String> strList, String substr) {
        List<String> matchedStrings = new ArrayList<>();
        if (strList != null && substr != null) {
            for (String str : strList) {
                if (str == null || !str.contains(substr)) {
                    continue;
                }
                matchedStrings.add(str);
                // 此处还有10行代码...
            }
        }
        return matchedStrings;
    }

    // 重构前的代码
    default List<String> matchStrings3(List<String> strList, String substr) {
        List<String> matchedStrings = new ArrayList<>();
        if (strList != null && substr != null) {
            for (String str : strList) {
                if (str != null) {
                    if (str.contains(substr)) {
                        matchedStrings.add(str);
                    }
                }
            }
        }
        return matchedStrings;
    }

    // 重构后的代码：先执行判空逻辑，再执行正常逻辑
    default List<String> matchStrings4(List<String> strList, String substr) {
        if (strList == null || substr == null) { //先判空
            return Collections.emptyList();
        }

        List<String> matchedStrings = new ArrayList<>();
        for (String str : strList) {
            if (str != null) {
                if (str.contains(substr)) {
                    matchedStrings.add(str);
                }
            }
        }
        return matchedStrings;
    }


    // 重构前的代码
    default List<String> appendSalts(List<String> passwords) {
        if (passwords == null || passwords.isEmpty()) {
            return Collections.emptyList();
        }

        List<String> passwordsWithSalt = new ArrayList<>();
        for (String password : passwords) {
            if (password == null) {
                continue;
            }
            if (password.length() < 8) {
                // ...
            } else {
                // ...
            }
        }
        return passwordsWithSalt;
    }

    // 重构后的代码：    将部分嵌套逻辑封装成函数调用，以此来减少嵌套
    default List<String> appendSalts1(List<String> passwords) {
        if (passwords == null || passwords.isEmpty()) {
            return Collections.emptyList();
        }

        List<String> passwordsWithSalt = new ArrayList<>();
        for (String password : passwords) {
            if (password == null) {
                continue;
            }
            passwordsWithSalt.add(appendSalt(password));
        }
        return passwordsWithSalt;
    }

    default String appendSalt(String password) {
        String passwordWithSalt = password;
        if (password.length() < 8) {
            // ...
        } else {
            // ...
        }
        return passwordWithSalt;
    }

    default double CalculateCircularArea(double radius) {
        return (3.1415) * radius * radius;
    }

    // 常量替代魔法数字
    public static final Double PI = 3.1415;
    default double CalculateCircularArea1(double radius) {
        return PI * radius * radius;
    }

}