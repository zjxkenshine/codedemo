package Chapter6.Test;

import Chapter6.Thread.Thread6_12;

public class Test6_12 {
    //	使用enum枚举数据类型实现单例模式
	
	/**
	 * 枚举enum和静态代码块的特性相似，在使用枚举类时，构造方法会被自动调用，
	 * 可以用这个特性实现单例模式设计
	 * 
	 * 因没有连接包，无法测试
	 * 
	 * 课本测试结果：违反了职责第一原则，修改为6_13
	 */
	
	public static void main(String[] args) {
		Thread6_12 t1=new Thread6_12();
		Thread6_12 t2=new Thread6_12();
		Thread6_12 t3=new Thread6_12();
		t1.start();
		t2.start();
		t3.start();
	}
	
	
	

}
