package Chapter1.Test;

import Chapter1.Thread.Thread1_30;

public class Test1_30 {
	//守护线程与用户线程
	/**1.线程中不存在非守护线程（用户线程）时，守护线程自动销毁
	 * 2.只要当前JVM实例中存在任何一个非守护线程没有结束，守护线程就在工作
	 * 	只有当最后一个非守护线程结束时，守护线程才随JVM一同结束
	 * 3.守护线程最典型的应用就是GC
	 * 4.方法：thread.setDaemon(true)
	 */
	
	public static void main(String[] args) {
		try{
			Thread1_30 thread=new Thread1_30();
			thread.setDaemon(true);              //设置为守护线程
			thread.start();
			Thread.sleep(5000);
			System.out.println("main线程结束，thread线程也不再打印，停止了");
		}catch(InterruptedException e){
			e.printStackTrace();
		}
	}

}
