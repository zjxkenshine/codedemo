package Chapter1.Test;

import Chapter1.Thread.Thread1_20;

public class Test1_20 {
	//stop()方法暴力停止（不推荐使用）方法stop()已作废
	/**使用stop()：
	 * 1.会抛出java.lang.ThreadDeath异常，不用显式捕捉
	 * 2.会使一些清理性工作得不到完成
	 * 3.会对锁定的对象解锁，导致数据得不到同步处理，出现数据不一致的结果
	 *   (使sychornized失效)
	**/
	public static void main(String[] args) {
		try{
			Thread1_20 thread=new Thread1_20();
			thread.start();
			Thread.sleep(8000);
			thread.stop();
			
		}catch(InterruptedException e){
			e.printStackTrace();
		}
	}

}
