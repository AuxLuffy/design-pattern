import com.luffy.design_pattern.id.RandomIdGenerator;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author sunzhangfei
 * @since 2021/8/12 3:55 下午
 */
public class TestIdGenerator {
    @Test
    public void testGetLastSubstrSplitByDot() {
        RandomIdGenerator idGenerator = new RandomIdGenerator();
        String substrSplitByDot = idGenerator.getLastSubstrSplitByDot("field1.field2.field3");
        assertEquals("field3", substrSplitByDot);
    }

    @Test
    public void testGetLastSubstrSplitByDot_nullOrEmpty() {
        RandomIdGenerator idGenerator = new RandomIdGenerator();
        String substrSplitByDot = idGenerator.getLastSubstrSplitByDot("");
        assertEquals("", substrSplitByDot);
        //失败了，代码运行报错，里面有空指针情况, 未判断入参为空的情况
        substrSplitByDot = idGenerator.getLastSubstrSplitByDot(null);
        assertNull(substrSplitByDot);
    }

    @Test
    public void testGenerateRandomAlphameric() {
        RandomIdGenerator idGenerator = new RandomIdGenerator();
        String actualRandomString = idGenerator.generateRandomAlphameric(6);
        assertNotNull(actualRandomString);
        assertEquals(6, actualRandomString.length());
        for (char c : actualRandomString.toCharArray()) {
            assertTrue(('0' <= c && c <= '9') || ('a' <= c && c <= 'z') || ('A' <= c && c <= 'Z'));
        }
    }

    @Test
    public void testGenerateRandomAlphameric_lengthLessThan0() {
        RandomIdGenerator idGenerator = new RandomIdGenerator();
        String actualRandomString = idGenerator.generateRandomAlphameric(0);
        //0的情况满足
        assertEquals("", actualRandomString);
        actualRandomString = idGenerator.generateRandomAlphameric(-1);
        //长度-1的情况会失败
        assertNull(null, actualRandomString);
    }
}