package Chapter1.Thread;

public class Thread1_25 extends Thread{
	//yield()方法：使线程放弃当前CPU资源，将它让给其他任务去占用cpu执行时间
	
	public void run(){
		long begin=System.currentTimeMillis();
		int count=0;
		for(int i=0;i<500000;i++){ 
			//Thread.yield();            //加上注释可以测试yield让资源
			count=count+1;
		}
		long end=System.currentTimeMillis();
		System.out.println("用时："+(end-begin)+"毫秒!");
	}

}
