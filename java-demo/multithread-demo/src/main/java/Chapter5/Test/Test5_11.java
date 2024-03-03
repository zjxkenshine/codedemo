package Chapter5.Test;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class Test5_11 {
	//方法schedule(TimeTask task,long delay)测试
	
	/**
	 * 该方法的作用是以执行schedule(TimeTask task,long delay)的时间为参考时间，
	 * 在延迟delay毫秒后执行一次task任务
	 */
	
	static public class MyTask extends TimerTask{
		@Override
		public void run() {
			// TODO Auto-generated method stub
			System.out.println("运行了,时间为:"+new Date());
		}
	}
	
	public static void main(String[] args) {
		MyTask tsk=new MyTask();
		Timer time=new Timer();
		System.out.println("当前时间："+new Date().toLocaleString());
		time.schedule(tsk, 5000);
		
	}

}
