package Chapter5.Test;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;


public class Test5_12 {
	//方法schedule(TimeTask task,long delay,long period)测试
	
	/**
	 * 方法schedule(TimeTask task,long delay,long period)的作用是从执行方法后的delay毫秒后开始
	 * 以period毫秒为周期无限次得循环执行task任务
	 */
	
	static public class MyTsk extends TimerTask{
		@Override
		public void run() {
			// TODO Auto-generated method stub
			System.out.println("运行了，时间为："+new Date());
		}
	}
	
	public static void main(String[] args) {
		MyTsk tsk=new MyTsk();
		Timer time=new Timer();
		System.out.println("当前时间："+new Date().toLocaleString());
		time.schedule(tsk, 5000,1000);    //5秒后以一秒为周期无限循环执行
	}

}
