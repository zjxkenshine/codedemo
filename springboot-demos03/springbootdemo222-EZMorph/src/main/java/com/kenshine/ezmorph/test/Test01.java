package com.kenshine.ezmorph.test;

import net.sf.ezmorph.MorphUtils;
import net.sf.ezmorph.MorpherRegistry;
import net.sf.ezmorph.array.ObjectArrayMorpher;
import net.sf.ezmorph.object.BooleanObjectMorpher;
import net.sf.ezmorph.object.StringMorpher;
import net.sf.ezmorph.primitive.IntMorpher;
import org.junit.Assert;

/**
 * @author ：kenshine
 * @date ：Created in 2022/1/15 9:30
 * @description：
 * @modified By：
 * @version: $
 */
public class Test01 {
    public static void main(String[] args) {
        //string转int
        int i = new IntMorpher().morph("123");
        Assert.assertEquals(123, i); // true!

        //int转string
        String str = (String) StringMorpher.getInstance().morph(123);
        Assert.assertEquals("123", str); // true!

        //字符串数组转boolean数组
        Boolean[] bools = (Boolean[]) new ObjectArrayMorpher(new BooleanObjectMorpher()).morph(new String[] { "true","false" });
        Assert.assertEquals(Boolean.TRUE, bools[0]); // true!
        Assert.assertEquals(Boolean.FALSE, bools[1]); // true!

        MorpherRegistry morperRegistry = new MorpherRegistry();
        MorphUtils.registerStandardMorphers(morperRegistry);
        Integer x = (Integer) morperRegistry.morph(Integer.class, "2");
        Assert.assertEquals(new Integer(2), x); // true!
    }
}
