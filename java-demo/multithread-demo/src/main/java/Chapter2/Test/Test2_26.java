package Chapter2.Test;

import Chapter2.Object.Object2_26.Inner;

public class Test2_26 {
	//内置类与同步实验1
	
	/**
	 * 测试:内置类中有两个同步方法，但使用的是不同的锁，打印的结果也是异步的
	 * 
	 * 测试结果：异步，打印结果混乱
	 */
	
	public static void main(String[] args) {
		final Inner inn=new Inner();
		
		Thread a=new Thread(new Runnable(){                //比较叼的线程创建方法
			@Override
			public void run() {
				// TODO Auto-generated method stub
				inn.MethodA();
			}
		},"A");
		
		Thread b=new Thread(new Runnable(){                //比较叼的线程创建方法
			@Override
			public void run() {
				// TODO Auto-generated method stub
				try {
					inn.MethodB();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		},"B");
		
		a.start();
		b.start();
	}

}
