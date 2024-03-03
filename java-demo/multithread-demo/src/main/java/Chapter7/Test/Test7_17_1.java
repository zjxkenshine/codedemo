package Chapter7.Test;

import Chapter7.Thread.Thread7_17_1;

public class Test7_17_1 {
	//线程组内处理异常
	
	/**
	 * 一个线程出现异常，线程组内其他线程会不会停止
	 * 线程组一个线程出现异常不会影响其他线程的运行
	 * @param args
	 */
	
	public static void main(String[] args) {
		ThreadGroup group=new ThreadGroup("线程组");
		Thread7_17_1[] tlist=new Thread7_17_1[10];
		
		for(int i=0;i<tlist.length;i++){
			tlist[i]=new Thread7_17_1(group, "线程"+(i+1),"111");
			tlist[i].start();
		}
		
		Thread7_17_1 th=new Thread7_17_1(group, "报错线程", "a");
		th.start();
		
	}

}
