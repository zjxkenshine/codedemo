package Chapter1.Test;

import Chapter1.Thread.Thread1_1;

public class Test1_1 {
	
	public static void main(String [] args){
		//调用的随机性测试
		
		Thread1_1 thread=new Thread1_1();
		thread.start();
		System.out.println("运行结束！");
	}
	

}
