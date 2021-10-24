package atguigu.interfaceNew;

/**
 * @author ：kenshine
 * @date ：Created in 2021/10/24 18:57
 * @description：测试默认方法接口
 * @modified By：
 * @version: $
 *
 * 类优先原则
 *
 * 类的父类和实现的接口方法冲突：
 * - 父类是具体方法，接口是默认方法，则使用父类的方法
 * - 父接口和另一个接口提供了相同方法，不管是不是默认方法，子类必须重写该方法
 *
 */
public interface MyFun1 {

    /**
     * 默认方法
     * @return
     */
    default String getName(){
        return "libo";
    }

    default Integer getAge(){
        return 22;
    }

}
