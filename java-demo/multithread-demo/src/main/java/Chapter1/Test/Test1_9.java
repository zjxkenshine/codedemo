package Chapter1.Test;

import Chapter1.Thread.Thread1_9;

public class Test1_9 {
//currentThread()���������ش�������ڱ��ĸ��̵߳���
	public static void main(String[] args) {
		 Thread1_9 thread=new Thread1_9();   //main
		 thread.start();               //thread-0
		 // thread.run();                  //main
	}
}
