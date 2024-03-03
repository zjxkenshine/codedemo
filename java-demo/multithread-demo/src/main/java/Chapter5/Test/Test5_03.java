package Chapter5.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;


public class Test5_03 {
	//方法schedule(TimeTask task,Date time) 计划时间早于当前时间： 提前执行的效果
	
	/**
	 * 如果执行任务的时间早于当前时间，则任务立即执行
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
