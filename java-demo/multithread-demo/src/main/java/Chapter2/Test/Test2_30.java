package Chapter2.Test;

import Chapter2.Object.Object2_30;

public class Test2_30 {
	//2_30: volatile解决同步死循环
	
	/**
	 * volatile关键字的作用： 强制从公共堆栈中取得变量值，而不是从私有数据堆栈中取得变量值
	 */
	
	public static void main(String[] args) {
		Object2_30 obj=new Object2_30();
		new Thread(obj).start();
		System.out.println("我要停止它!stopThread="+Thread.currentThread().getName());
		obj.setPrint(false);
	}

}
