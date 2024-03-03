package Chapter1.Test;

import Chapter1.Thread.Thread1_9;

public class Test1_9 {
//currentThread()方法：返回代码段正在被哪个线程调用
	public static void main(String[] args) {
		 Thread1_9 thread=new Thread1_9();   //main
		 thread.start();               //thread-0
		 // thread.run();                  //main
	}
}
