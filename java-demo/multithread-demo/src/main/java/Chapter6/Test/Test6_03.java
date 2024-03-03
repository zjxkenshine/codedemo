package Chapter6.Test;

import Chapter6.Thread.Thread6_03;

public class Test6_03 {
	//延迟加载/懒汉模式解析
	
	/**
	 * 延迟加载就是在调用get方法时实例才被创建，常见的实现方法时在get方法中进行new实例化
	 * 
	 * 延迟加载/懒汉模式是在调用方法时实例才被创建
	 * 
	 * 在多线程环境中就会取到多个对象，与单例模式的初衷相悖
	 */
	
	
	public static void main(String[] args) {
		Thread6_03 t1=new Thread6_03();
		Thread6_03 t2=new Thread6_03();
		t1.start();
		t2.start();
	}
	

}
