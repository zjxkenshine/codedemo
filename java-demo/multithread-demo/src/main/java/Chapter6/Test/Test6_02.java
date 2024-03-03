package Chapter6.Test;

import Chapter6.Thread.Thread6_02;

public class Test6_02 {
	//立即加载/饿汉模式
	
	/*立即加载就是使用类的时候已经将对象创建完毕了，常见的实现方法就是new实例化
	 * 
	 *立即加载/饿汉模式是在调用方法前，实例就已经被创建了
	 * 
	 */
	
	public static void main(String[] args) {
		Thread6_02 t1=new Thread6_02();
		Thread6_02 t2=new Thread6_02();
		Thread6_02 t3=new Thread6_02();
		t1.start();
		t2.start();
		t3.start();
		//得到的hashCode是同一个，说明是同一个对象
	}
	
	

}
