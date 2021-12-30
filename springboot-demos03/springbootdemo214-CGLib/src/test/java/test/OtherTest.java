package test;

import com.kenshine.cglib.demo03.*;
import net.sf.cglib.beans.*;
import net.sf.cglib.core.KeyFactory;
import net.sf.cglib.core.Signature;
import net.sf.cglib.proxy.InterfaceMaker;
import net.sf.cglib.reflect.ConstructorDelegate;
import net.sf.cglib.reflect.FastClass;
import net.sf.cglib.reflect.FastMethod;
import net.sf.cglib.reflect.MethodDelegate;
import net.sf.cglib.util.ParallelSorter;
import net.sf.cglib.util.StringSwitcher;
import org.junit.Assert;
import org.junit.Test;
import org.objectweb.asm.Type;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * @author ：kenshine
 * @date ：Created in 2021/12/30 22:24
 * @description：其他API
 * @modified By：
 * @version: $
 */
public class OtherTest {

    /**
     * 1. ImmutableBean
     */
    @Test(expected = IllegalStateException.class)
    public void test01_ImmutableBean(){
        SampleBean bean = new SampleBean();
        bean.setValue("Hello world");
        SampleBean immutableBean = (SampleBean) ImmutableBean.create(bean); //创建不可变类
        assertEquals("Hello world",immutableBean.getValue());
        bean.setValue("Hello world, again"); //可以通过底层对象来进行修改
        assertEquals("Hello world, again", immutableBean.getValue());
        immutableBean.setValue("Hello cglib"); //直接修改将throw exception
    }

    /**
     * .2. Bean generator 运行时动态创建bean
     */
    @Test
    public void test02_Bean_Generator() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        BeanGenerator beanGenerator = new BeanGenerator();
        beanGenerator.addProperty("value",String.class);
        Object myBean = beanGenerator.create();
        Method setter = myBean.getClass().getMethod("setValue",String.class);
        setter.invoke(myBean,"Hello cglib");

        Method getter = myBean.getClass().getMethod("getValue");
        assertEquals("Hello cglib",getter.invoke(myBean));
    }

    /**
     * .3. BeanCopier 从一个bean复制到另一个bean中，而且其还提供了一个转换器，用来在转换的时候对bean的属性进行操作
     */
    @Test
    public void test03_BeanCopier() throws Exception{
        BeanCopier copier = BeanCopier.create(SampleBean.class, OtherSampleBean.class, false);//设置为true，则使用converter
        SampleBean myBean = new SampleBean();
        myBean.setValue("Hello cglib");
        OtherSampleBean otherBean = new OtherSampleBean();
        copier.copy(myBean, otherBean, null); //设置为true，则传入converter指明怎么进行转换
        assertEquals("Hello cglib", otherBean.getValue());
    }

    /**
     * 4.BulkBean 属性操作
     */
    @Test
    public void test04_BulkBean() throws Exception{
        BulkBean bulkBean = BulkBean.create(SampleBean.class,
                new String[]{"getValue"},
                new String[]{"setValue"},
                new Class[]{String.class});
        SampleBean bean = new SampleBean();
        bean.setValue("Hello world");
        Object[] propertyValues = bulkBean.getPropertyValues(bean);
        assertEquals(1, bulkBean.getPropertyValues(bean).length);
        assertEquals("Hello world", bulkBean.getPropertyValues(bean)[0]);
        bulkBean.setPropertyValues(bean,new Object[]{"Hello cglib"});
        assertEquals("Hello cglib", bean.getValue());
    }

    /**
     * 5.BeanMap 将一个bean对象中的所有属性转换为一个String-to-Obejct的Java Map
     * Bean转Map
     */
    @Test
    public void test05_BeanMap() throws Exception{
        BeanGenerator generator = new BeanGenerator();
        generator.addProperty("username",String.class);
        generator.addProperty("password",String.class);
        Object bean = generator.create();
        Method setUserName = bean.getClass().getMethod("setUsername", String.class);
        Method setPassword = bean.getClass().getMethod("setPassword", String.class);
        setUserName.invoke(bean, "admin");
        setPassword.invoke(bean,"password");
        BeanMap map = BeanMap.create(bean);
        //获取username属性值
        Assert.assertEquals("admin", map.get("username"));
        Assert.assertEquals("password", map.get("password"));
    }

    /**
     * 6.keyFactory
     * keyFactory类用来动态生成接口的实例，接口需要只包含一个newInstance方法，返回一个Object
     */
    @Test
    public void test06_KeyFactory(){
        SampleKeyFactory keyFactory = (SampleKeyFactory) KeyFactory.create(SampleKeyFactory.class);
        Object key = keyFactory.newInstance("foo", 42);
        Object key1 = keyFactory.newInstance("foo", 42);
        Assert.assertEquals(key,key1);//测试参数相同，结果是否相等
    }

    /**
     * 7.StringSwitcher 模拟一个String到int类型的Map类型
     */
    @Test
    public void test07_StringSwitcher() throws Exception{
        String[] strings = new String[]{"one", "two"};
        int[] values = new int[]{10,20};
        StringSwitcher stringSwitcher = StringSwitcher.create(strings,values,true);
        assertEquals(10, stringSwitcher.intValue("one"));
        assertEquals(20, stringSwitcher.intValue("two"));
        assertEquals(-1, stringSwitcher.intValue("three"));
    }

    /**
     * 8.InterfaceMarker 创建一个新接口
     */
    @Test
    public void test08_InterfaceMarker() throws Exception{
        Signature signature = new Signature("foo", Type.DOUBLE_TYPE, new Type[]{Type.INT_TYPE});
        InterfaceMaker interfaceMaker = new InterfaceMaker();
        interfaceMaker.add(signature, new Type[0]);
        Class iface = interfaceMaker.create();
        assertEquals(1, iface.getMethods().length);
        assertEquals("foo", iface.getMethods()[0].getName());
        assertEquals(double.class, iface.getMethods()[0].getReturnType());
    }

    /**
     * 9.MethodDelegate 方法代理
     */
    @Test
    public void test09_MethodDelegate()  throws Exception{
        SampleBean bean = new SampleBean();
        bean.setValue("Hello cglib");
        //bean 无参构造的bean
        //getValue 被代理的方法
        //BeanDelegate.class 只含有一个方法的接口
        BeanDelegate delegate = (BeanDelegate) MethodDelegate.create(bean,"getValue", BeanDelegate.class);
        assertEquals("Hello cglib", delegate. getValueFromDelegate());
    }

    /**
     * 10.ConstructorDelegate 构造函数代理
     */
    @Test
    public void test10_ConstructorDelegate() throws Exception{
        SampleBeanConstructorDelegate constructorDelegate = (SampleBeanConstructorDelegate) ConstructorDelegate.create(
                SampleBean.class, SampleBeanConstructorDelegate.class);
        SampleBean bean = (SampleBean) constructorDelegate.newInstance("Hello world");
        assertTrue(SampleBean.class.isAssignableFrom(bean.getClass()));
        System.out.println(bean.getValue());
    }

    /**
     * 11.ParallelSorter 并行排序
     * 多个数组同时排序
     */
    @Test
    public void testParallelSorter() throws Exception{
        Integer[][] value = {
                {4, 3, 9, 0},
                {2, 1, 6, 0}
        };
        ParallelSorter.create(value).mergeSort(0);
        // 0349
        // 0126
        for(Integer[] row : value){
            int former = -1;
            for(int val : row){
                assertTrue(former < val);
                former = val;
            }
        }
    }

    /**
     * 12.FastClass
     */
    @Test
    public void test12_FastClass() throws Exception{
        FastClass fastClass = FastClass.create(SampleBean.class);
        FastMethod fastMethod = fastClass.getMethod("getValue",new Class[0]);
        SampleBean bean = new SampleBean();
        bean.setValue("Hello world");
        assertEquals("Hello world",fastMethod.invoke(bean, new Object[0]));
    }







}
