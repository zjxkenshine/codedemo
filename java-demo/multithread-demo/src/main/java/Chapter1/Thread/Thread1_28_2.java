package Chapter1.Thread;

import java.util.Random;

public class Thread1_28_2 extends Thread{
	//�߳����ȼ��������
	public void run(){
		long begin=System.currentTimeMillis();
		for(int i=0;i<1000;i++){
			Random ran=new Random();
			ran.nextInt();
		}
		long end=System.currentTimeMillis();
		System.out.println("thread 222222 use time="+(end-begin));
	}

}
