import com.luffy.design_pattern.opt.skills.Text;
import org.junit.Test;

import java.net.InetAddress;
import java.net.UnknownHostException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

/**
 * @author sunzhangfei
 * @since 2021/8/3 7:29 下午
 */
public class TestCode1 {
    @Test
    public void testToNumber() {
        Text text = new Text("123");
        assertEquals(new Integer(123), text.toNumber());
    }

    @Test
    public void nonOrEmptyString() {
        Text text = new Text("");
        assertNull(text.toNumber());

        Text text1 = new Text(null);
        assertNull(text1.toNumber());
    }

    @Test
    public void numberContainsLeadingOrTrailingSpace() {
        Text text1 = new Text(" 123");
        assertEquals(new Integer(123), text1.toNumber());

        Text text2 = new Text("123 ");
        assertEquals(new Integer(123), text2.toNumber());

        Text text3 = new Text("  123  ");
        assertEquals(new Integer(123), text3.toNumber());
    }

    @Test
    public void testNumberContainsInvalidCharacters() {
        Text text1 = new Text(" 12a3");
        assertNull(text1.toNumber());

        Text text2 = new Text("1 23 ");
        assertNull(text2.toNumber());

        Text text3 = new Text("  +123  ");
        assertEquals(new Integer(123), text3.toNumber());
    }

    @Test
    public void testInet() throws UnknownHostException {
        String hostName = InetAddress.getLocalHost().getHostName();
        String[] split = hostName.split("\\.");
        System.out.println(hostName);
    }

}