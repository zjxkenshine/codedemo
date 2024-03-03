package Chapter1.Test;

import Chapter1.Thread.SychornizedObject1_23_1;

public class Test1_23_1 {
	//suspend()与resume()缺点例子：独占公共同步对象
	public static void main(String[] args) {
		try{
			final SychornizedObject1_23_1 object =new SychornizedObject1_23_1();
			Thread thread1=new Thread(){
				public void run(){
					object.printString();
				}
			};
			thread1.setName("a");
			thread1.start();
			Thread.sleep(1000);
			Thread thread2=new Thread(){
				public void run(){
					System.out.println("thread2启动了，但进入不了printString()方法");
					System.out.println("因为printString()方法被a线程锁定并且永远暂停了！");
					object.printString();               //执行不了该方法
				}
			};
			thread2.start();
		}catch(InterruptedException e){
			e.printStackTrace();
		}
	}
}
