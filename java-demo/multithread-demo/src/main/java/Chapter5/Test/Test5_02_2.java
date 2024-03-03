package Chapter5.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;


public class Test5_02_2 {
	//将Timer变为守护线程
	
	/**
	 * 程序运行后马上终止，不会执行TimerTask中的任务,因为程序已经终止了
	 */

	private static Timer time=new Timer(true);            //初始为守护线程
	
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
			String dateString="2017-10-10 21:04:00";
			Date dt=sdf.parse(dateString);
			System.out.println("字符串时间："+dt.toLocaleString()+"当前时间："+new Date().toLocaleString());
			time.schedule(tsk, dt);
		}catch (ParseException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
