package test;

import net.sf.cglib.proxy.Mixin;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author ：kenshine
 * @date ：Created in 2021/12/30 22:39
 * @description：
 * @modified By：
 * @version: $
 *
 * Mixin
 */
public class MixinInterfaceTest {
    interface Interface1{
        String first();
    }
    interface Interface2{
        String second();
    }

    class Class1 implements Interface1{
        @Override
        public String first() {
            return "first";
        }
    }

    class Class2 implements Interface2{
        @Override
        public String second() {
            return "second";
        }
    }

    interface MixinInterface extends Interface1, Interface2{

    }

    /**
     * Mixin 将不同接口实现组合在一起
     */
    @Test
    public void testMixin() throws Exception{
        Mixin mixin = Mixin.create(new Class[]{Interface1.class, Interface2.class,
                MixinInterface.class}, new Object[]{new Class1(),new Class2()});
        MixinInterface mixinDelegate = (MixinInterface) mixin;
        assertEquals("first", mixinDelegate.first());
        assertEquals("second", mixinDelegate.second());
    }
}
