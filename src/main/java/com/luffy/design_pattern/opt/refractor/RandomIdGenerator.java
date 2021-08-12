package com.luffy.design_pattern.opt.refractor;

import com.google.common.annotations.VisibleForTesting;
import com.luffy.design_pattern.opt.IdGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * 随机id生成器
 * 一、提高代码的可读性
 * 1. 把类改成面向接口的，实现自接口，并在类名上做可扩展重命名，以id生成的机制来命名，随机id生成器，为以后递增的id生成器作预留
 * 2. 把id的三个部分拆成三个部分，抽到三个变量后分别获取
 * 3. 将随机数生成的代码中不可读的判断条件拆成变量来说明代码表示的意思
 * 4. 将获取hostname的前后两种不同意义的hostname分开命名
 * 二、提高代码的可测试性
 * 1. 将代码由静态代码改为实现接口，面向接口而非实现，第一步已完成
 * 2. generate方法代码实现依赖运行环境（本机名）、时间函数、随机函数，所以其本身可测试性不好，可以把依赖项单独抽出来，将getLastFieldOfHostName方法中的分隔字段的实现抽成getLastSubstrSplitByDot函数，因为getLastFieldOfHostName函数依赖本地主机名，所以剥离出主要代码后这个函数变得非常简单，可以不用测试，我们只需要重点测试getLastSubstrSplitByDot即可
 * alphameric 字母数字的 == alphanumeric
 * Delimiter 分隔符
 *
 * @author sunzhangfei
 * @since 2021/8/12 2:35 下午
 */
public class RandomIdGenerator implements LogTraceIdGenerator {
    private static final Logger logger = LoggerFactory.getLogger(IdGenerator.class.getSimpleName());

    @Override
    public String generate() {
        String substrHostName = getLastFieldOfHostName();
        long currentTimeMillis = System.currentTimeMillis();
        String randomString = generateRandomAlphameric(8);
        return String.format("%s-%d-%s", substrHostName, currentTimeMillis, randomString);
    }

    private String getLastFieldOfHostName() {
        String subHostName = null;
        try {
            String hostName = InetAddress.getLocalHost().getHostName();
            subHostName = getLastSubstrSplitByDot(hostName);
        } catch (UnknownHostException e) {
            logger.warn("Unknown host", e);
        }
        return subHostName;
    }

    @VisibleForTesting
    public String getLastSubstrSplitByDot(String hostName) {
        String[] tokens = hostName.split("\\.");
        return tokens[tokens.length - 1];
    }

    @VisibleForTesting
    public String generateRandomAlphameric(int length) {
        char[] randomChars = new char[length];
        int count = 0;
        while (count < length) {
            int maxAscii = 'z';
            char randomChar = (char) (Math.random() * maxAscii + 1);
            boolean isDigit = randomChar >= '0' && randomChar <= '9';
            boolean isUpperCase = randomChar >= 'A' && randomChar <= 'Z';
            boolean isLowerCase = randomChar >= 'a' && randomChar < 'z';
            if (isDigit || isLowerCase || isUpperCase) {
                randomChars[count] = randomChar;
                ++count;
            }
        }
        return new String(randomChars);
    }

}