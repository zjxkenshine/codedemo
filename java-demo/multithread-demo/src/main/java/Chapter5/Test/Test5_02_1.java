package Chapter5.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class Test5_02_1 {
	//方法schedule(TimeTask task,Date time)---执行任务的时间晚于当前时间：在未来执行
	
	/**
	 * schedule(TimeTask task,Date time)的作用是在指定时间执行某一任务
	 * 
	 * 运行结果:任务执行完进程未销毁；
	 * 创建一个Timer就是启动一个新的线程，这个新启动的线程并不是守护线程，它会一直运行
	 */
	
	private static Timer time=new Timer();
	
	static public class MyTask extends TimerTask{
		@Override
		public void run() {
			// TODO Auto-generated method stub
			System.out.println("运行了,时间为"+System.currentTimeMillis());
		}
	}
	
	public static void main(String[] args) {
		try{
			MyTask tsk=new MyTask();
			SimpleDateFormat sdf=new SimpleDateFormat("yy-MM-dd HH:mm:ss");
			String dateString="2017-10-10 20:57:00";
			Date dt=sdf.parse(dateString);
			System.out.println("字符串时间："+dt.toLocaleString()+"当前时间："+new Date().toLocaleString());
			time.schedule(tsk, dt);
		}catch (ParseException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
