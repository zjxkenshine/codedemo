package Chapter5.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class Test5_04_1 {
	//方法schedule(TimeTask task,Date time) 多个TimerTask任务及延时的测试
	
	/**
	 * TimerTask是以队列的方式一个一个被顺序执行，所以执行的时间有可能和预计的时间不一样
	 * 前面的任务耗时可能较长，则后面的任务运行的时间也会被延迟
	 */
	
	private static Timer timer=new Timer();
	
	static public class Tsk1 extends TimerTask{
		@Override
		public void run() {
			// TODO Auto-generated method stub
			System.out.println("tsk1运行了,时间为"+System.currentTimeMillis());
		}
	}
	
	static public class Tsk2 extends TimerTask{
		@Override
		public void run() {
			// TODO Auto-generated method stub
			System.out.println("tsk2运行了,时间为"+System.currentTimeMillis());
		}
	}
	
	
	public static void main(String[] args) {
		try{
			Tsk1 tsk1=new Tsk1();
			Tsk2 tsk2=new Tsk2();
			SimpleDateFormat sdf1=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			SimpleDateFormat sdf2=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String day1="2017-10-10 21:49:00";
			String day2="2017-10-10 21:49:10";
			
			Date d1=sdf1.parse(day1);
			Date d2=sdf2.parse(day2);
			
			System.out.println("字符串1执行时间："+d1.toLocaleString()+" 当前的时间："+new Date().toLocaleString());
			System.out.println("字符串2执行时间："+d1.toLocaleString()+" 当前的时间："+new Date().toLocaleString());
			
			timer.schedule(tsk1, d1);
			timer.schedule(tsk2, d2);
			
		}catch (ParseException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
