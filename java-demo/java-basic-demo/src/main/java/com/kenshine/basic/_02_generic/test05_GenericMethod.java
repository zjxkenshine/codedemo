package com.kenshine.basic._02_generic;

import org.junit.Test;

/**
 * @author ：kenshine
 * @date ：Created in 2022/1/9 10:28
 * @description：泛型方法
 * @modified By：
 * @version: $
 *
 * 泛型方法，是在调用方法的时候指明泛型的具体类型
 * 能写方法的地方就能写泛型方法
 */
public class test05_GenericMethod {

    @Test
    public void test01() throws IllegalAccessException, InstantiationException {
        Object obj = genericMethod(getClass());
        System.out.println(obj instanceof test05_GenericMethod);
    }

    /**
     * 泛型方法 生成某个类实例
     */
    public <T> T genericMethod(Class<T> tClass)throws InstantiationException , IllegalAccessException{
        T instance = tClass.newInstance();
        return instance;
    }

    /**
     * 泛型方法
     */
    public <T> T showKeyName(Generic<T> container){
        System.out.println("container key :" + container.getKey());
        //当然这个例子举的不太合适，只是为了说明泛型方法的特性。
        T test = container.getKey();
        return test;
    }

    //这也不是一个泛型方法，这就是一个普通的方法，只是使用了Generic<Number>这个泛型类做形参而已。
    public void showKeyValue1(Generic<Number> obj){
        System.out.println(obj.getKey());
    }

    //这也不是一个泛型方法，这也是一个普通的方法，只不过使用了泛型通配符?
    //同时这也印证了泛型通配符章节所描述的，?是一种类型实参，可以看做为Number等所有类的父类
    public void showKeyValue2(Generic<?> obj){
        System.out.println(obj.getKey());
    }

    /**
     * 这个方法是有问题的，编译器会为我们提示错误信息："UnKnown class 'E' "
     * 虽然我们声明了<T>,也表明了这是一个可以处理泛型的类型的泛型方法。
     * 但是只声明了泛型类型T，并未声明泛型类型E，因此编译器并不知道该如何处理E这个类型。
     public <T> T showKeyName(Generic<E> container){
     }
     */

    /**
     * 这个方法也是有问题的，编译器会为我们提示错误信息："UnKnown class 'T' "
     * 对于编译器来说T这个类型并未项目中声明过，因此编译也不知道该如何编译这个类。
     public void showkey(T genericObj){
     }
     */

}

/**
 * 泛型类
 */
class Generic2<T>{
    private T key;

    public Generic2(T key) {
        this.key = key;
    }

    //虽然在方法中使用了泛型，但是这并不是一个泛型方法。只是一个成员方法
    public T getKey(){
        return key;
    }

    /**
     * 这个方法显然是有问题的，在编译器会给我们提示这样的错误信息"cannot reslove symbol E"
     * 因为在类的声明中并未声明泛型E，所以在使用E做形参和返回值类型时，编译器会无法识别。
     public E setKey(E key){
     this.key = keu
     }
     */
}