package Chapter1.Test;

import Chapter1.Thread.Thread1_25;

public class Test1_25 {
	//yield()方法：使线程放弃当前CPU资源，将它让给其他任务去占用cpu执行时间
	
	public static void main(String[] args) {
		Thread1_25 thread=new Thread1_25();
		thread.start();
	}

}
