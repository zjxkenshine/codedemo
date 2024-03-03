package Chapter2.Test;

import Chapter2.Object.Object2_29;

public class Test2_29 {
	//volatile关键字与死循环
	
	/**1.不是在多继承的情况下，Thread与runnable无区别，一旦出现多继承，则使用Runnable接口就很有必要
	 * 
	 * 2.本例测试非线程环境下的死循环
	 * 
	 * 3.测试结果:main线程死循环，程序无法执行后面的代码
	 * 
	 * 4.解决方法：多线程
	 */
	
	public static void main(String[] args) {
		Object2_29 obj=new Object2_29();
		obj.MethodA();
		System.out.println("方法A停止了");
		obj.setPrint(false);
	}

}
