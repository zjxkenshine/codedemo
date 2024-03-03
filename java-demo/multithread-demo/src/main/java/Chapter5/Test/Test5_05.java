package Chapter5.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class Test5_05 {
	//方法schedule(TimeTask task,Date firstTime,long period) 执行任务的时间晚于当前时间：在未来执行的效果
	
	/**schedule(TimeTask task,Date firstTime,long period)方法的作用是在指定的日期firstTime后，
	 *  按照指定的间隔周期性得无限循环执行某一任务
	 */
	
	static public class Mytask extends TimerTask{
		@Override
		public void run() {
			// TODO Auto-generated method stub
			System.out.println("运行了，时间为"+new Date());
		}
	}
	
	public static void main(String[] args) {
		try{
			Mytask tsk=new Mytask();
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String day="2017-10-11 11:07:00";
			Timer time=new Timer();
			Date d1=sdf.parse(day);
			System.out.println("字符串时间"+d1.toLocaleString()+"当前时间"+new Date().toLocaleString());
			time.schedule(tsk, d1, 4000);                       //每4秒循环一次
		}catch (ParseException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	

}
