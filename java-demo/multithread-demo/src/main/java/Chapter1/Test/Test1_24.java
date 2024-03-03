package Chapter1.Test;

import Chapter1.Thread.MyObject1_24;

public class Test1_24 {
	//suspend()与resume()缺点二：导致数据不同步
	
	public static void main(String[] args) throws InterruptedException {
		final MyObject1_24 myobject =new MyObject1_24();
		Thread thread1=new Thread(){
			public void run(){
				myobject.setValue("a", "aaa");
			}
		};
		thread1.setName("a");
		thread1.start();
		Thread.sleep(500);
		Thread thread2=new Thread(){
			public void run(){
				myobject.printUsernamePassword();
			}
		};
		thread2.start();
	}
}
