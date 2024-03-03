package Chapter3.Test;

import Chapter3.Object.C3_10;
import Chapter3.Object.P3_10;
import Chapter3.Thread.Thread3_10A;
import Chapter3.Thread.Thread3_10B;

public class Test3_10 {
	//多生产与多消费：【操作值】---出现假死
	
	/**1.进程假死：进程中的所有线程都处在WATING状态
	 * 
	 * 2.原因：notify可能唤醒同类，如生产者唤醒生产者，造成假死
	 * 
	 * 3.解决方法：把notify()方法改为notifyAll()
	 * 
	 * 
	 * @throws InterruptedException
	 */
	
	public static void main(String[] args) throws InterruptedException {
		String lock=new String("");
		P3_10 p=new P3_10(lock);
		C3_10 c=new C3_10(lock);
		Thread3_10A[] listp=new Thread3_10A[2];
		Thread3_10B[] listc=new Thread3_10B[2];
		for(int i=0;i<2;i++){
			listp[i]=new Thread3_10A(p);
			listp[i].setName("生产者"+(i+1));
			listc[i]=new Thread3_10B(c);
			listc[i].setName("消费者"+(i+1));
			listp[i].start();
			listc[i].start();
		}
		Thread.sleep(5000);
		Thread[] tlist=new Thread[Thread.currentThread().getThreadGroup().activeCount()];
		Thread.currentThread().getThreadGroup().enumerate(tlist);
		for(int i=0;i<tlist.length;i++){
			System.out.println(tlist[i].getName()+" "+tlist[i].getState());
		}
	}

}
