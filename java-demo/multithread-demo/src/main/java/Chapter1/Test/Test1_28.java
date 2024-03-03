package Chapter1.Test;

import Chapter1.Thread.Thread1_28_1;
import Chapter1.Thread.Thread1_28_2;

public class Test1_28 {
	//线程优先级的随机性
	//优先级较高的线程不一定每次都先执行完
	public static void main(String[] args) {
		for(int i=0;i<5;i++){
			Thread1_28_1 thread1=new Thread1_28_1();
			thread1.setPriority(5);
			thread1.start();
			Thread1_28_2 thread2=new Thread1_28_2();
			thread2.setPriority(6);
			thread2.start();
		}
	}
}
