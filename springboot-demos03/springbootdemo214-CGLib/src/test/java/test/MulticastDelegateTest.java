package test;

import net.sf.cglib.reflect.MulticastDelegate;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author ：kenshine
 * @date ：Created in 2021/12/30 22:54
 * @description：
 * @modified By：
 * @version: $
 */
public class MulticastDelegateTest {
    public interface DelegatationProvider {
        void setValue(String value);
    }

    public class SimpleMulticastBean implements DelegatationProvider {
        private String value;
        @Override
        public void setValue(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }

    @Test
    public void testMulticastDelegate() throws Exception{
        MulticastDelegate multicastDelegate = MulticastDelegate.create(DelegatationProvider.class);
        SimpleMulticastBean first = new SimpleMulticastBean();
        SimpleMulticastBean second = new SimpleMulticastBean();
        multicastDelegate = multicastDelegate.add(first);
        multicastDelegate  = multicastDelegate.add(second);

        DelegatationProvider provider = (DelegatationProvider) multicastDelegate;
        provider.setValue("Hello world");

        assertEquals("Hello world", first.getValue());
        assertEquals("Hello world", second.getValue());
    }
}
