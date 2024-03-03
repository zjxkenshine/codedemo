package Chapter1.Thread;

import java.util.Random;

public class Thread1_27_2 extends Thread {
	//线程优先级的规则性
public void run(){
	long begin=System.currentTimeMillis();
	long addResult=0;
	for(int j=0;j<10;j++){
		for(int i=0;i<20000;i++){
			Random ran=new Random();
			ran.nextInt();
			addResult=addResult+i;
		}
	}
	long end=System.currentTimeMillis();
	System.out.println("thread2222222 use time="+(end-begin));
	}
}
