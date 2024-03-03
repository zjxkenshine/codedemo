package Chapter2.Test;

import Chapter2.Object.Object2_27.InnerClass1;
import Chapter2.Object.Object2_27.InnerClass2;

public class Test2_27 {
	//内置类与同步实验2
	
	/**
	 * 测试：同步代码块synchronized(class2)对class2上锁后，
	 * 		其他线程只能以同步方式调用class2中的静态同步方法
	 * 
	 * 结果:方法AB，BC异步,AC同步
	 * 
	 */
	
	public static void main(String[] args) {
		final InnerClass1 in1=new InnerClass1();
		final InnerClass2 in2=new InnerClass2();
		
		Thread t1=new Thread(new Runnable(){            //比较叼的线程创建方法
			public void run() {
				// TODO Auto-generated method stub
				in1.method1(in2);
			}
		},"AAA");
		
		Thread t2=new Thread(new Runnable(){
			public void run() {
				// TODO Auto-generated method stub
				in1.method2();
			}
		},"BBB");
		
		Thread t3=new Thread(new Runnable(){
			public void run() {
				// TODO Auto-generated method stub
				in2.method3();
			}
		},"CCC");
		
		t1.start();
		t2.start();
		t3.start();
		
	}

}
