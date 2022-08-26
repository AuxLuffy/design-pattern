package com.luffy.design_pattern.opt;


import com.luffy.design_pattern.id.RandomIdGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * id生成器
 * 如何发现代码质量问题
 * **常规checklist**
 * * 目录设置是否合理、模块划分是否清晰、代码结构是否满足“高内聚、松耦合”？
 * * 是否遵循经典的设计原则和设计思想（SOLID/DRY/KISS/YAGNI/LOD等）？
 * * 设计模式是否应用得当？是否有过度设计？
 * * 代码是否容易扩展？如果要添加新功能，是否容易实现？
 * * 代码是否可以复用？是否可以复用已有的项目代码或类库？是否有重复造轮子？
 * * 代码是否容易测试？单元测试是否全面覆盖各种正常和异常的情况？
 * * 代码是否易读？是否符合编码规范（比如命名和注释是否恰当、代码风格是否一致等）？
 * <p>
 * **业务需求checklist**
 * * 代码是否实现了预期的业务需求？
 * * 逻辑是否正确？是否处理了各种异常情况？
 * * 日志打印是否得当？是否方便debug排查问题？
 * * 接口是否易用？是否支持幂等、事务等？
 * * 代码是否存在并发问题？是否线程安全？
 * * 性能是否有优化空间，比如，SQL/算法是否可以优化？
 * * 是否有安全漏洞？比如，输入输出校验是否全面？
 * <p>
 * 业务无关评价
 * 代码比较简单，只有一个类，所以不涉及目录设置、模块划分、代码结构问题，也不违反基本的设计原则。它没有应用设计模式，所以也不存在不合理使用和过渡设计的问题。
 * 其次，IdGenerator设计成了实现类而非接口，调用者直接依赖实现而非非接口，违反了基于接口而非实现的设计思想。实际上，设计成实现类也问题不大，如果哪天id生成算法变了，我们只需要直接修改实现类的代码就可以了，但是如果项目中需要同时存在两种ID生成算法，也就是要同时存在两个IdGenerator实现类，这时我们把它定义成接口就比较合理了
 * 再次，把类中的方法定义为静态方法，会影响使用该函数的代码的可测试性。同时generate本身的可测试性也不好，需要做比较大的重构。除此之外，小王也没有编写单元测试代码，我们需要在重构时进行补充。
 * 最后，虽然此类只包含一个函数，代码行数也不多，但代码的可读性不好，特别是随机字符串生成的那部分代码，一方面，代码完全没有注释，生成算法比较难以读懂，另一方面，代码里有很多魔法数，严重影响代码的可读性。重构时要注意这里。
 * <p>
 * 业务相关评价
 * 代码虽有小概率产生id冲突的可能，但在可接受范围内，满足预期业务需求
 * 逻辑上未考虑hostname获取不到为空的情况
 * 日志打印还算到位方便排查问题
 * 只有一个接口，易用性没问题
 * 对外部没有共享变量依赖，所以线程安全
 * 性能上，每次生成id都需要获取本机名，比较耗时，可以优化，同时随机数的区间仅为(0-9)(a-z)(A-Z),但确随机了0-122的数字，有很多情况下会产生无效数字，随机的算法可以优化
 *
 * @author sunzhangfei
 * @since 2021/8/11 10:42 上午
 */
public class IdGenerator {
    private static final Logger logger = LoggerFactory.getLogger(IdGenerator.class.getSimpleName());
    private static final Logutil L = new Logutil();

    public static void main(String[] args) {
//        testLog();
        System.out.println(generate());
        RandomIdGenerator generator = new RandomIdGenerator();
        generator.generate();
        System.out.println(generator.generateRandomAlphameric(9));
    }

    public static String generate() {
        String id = "";
        try {
            String hostName = InetAddress.getLocalHost().getHostName();
            String[] tokens = hostName.split("\\.");
            if (tokens.length > 0) {
                hostName = tokens[tokens.length - 1];
            }

            char[] randomChars = new char[8];
            int count = 0;
            while (count < 8) {
                char randomChar = (char) (Math.random() * 123);
                if ((randomChar >= '0' && randomChar <= '9') || (randomChar >= 'a' && randomChar < 'z') || (randomChar >= 'A' && randomChar <= 'Z')) {
                    randomChars[count] = randomChar;
                    count++;
                }
            }
            id = String.format("%s-%d-%s", hostName, System.currentTimeMillis(), new String(randomChars));

        } catch (UnknownHostException e) {
            logger.warn("Unknown host", e);
        }
        return id;
    }

    private static void testLog() {
        logger.error("helloworld error");
        logger.warn("Hello world warn");
        logger.info("Hello world info");
        logger.debug("Hello world debug");
        logger.trace("Hello world trace");
        Logutil.d("hello");
    }
}