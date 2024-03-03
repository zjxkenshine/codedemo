package Chapter2.Thread;

import Chapter2.Object.Object2_06_1;

public class Thread2_06_1 extends Thread{
	//synchronized锁的重入,非继承环境
	
	public void run(){
		Object2_06_1 obj=new Object2_06_1();
		obj.service1();
	}

}
