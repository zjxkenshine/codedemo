package Chapter5.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;


public class Test5_06 {
	//方法schedule(TimeTask task,Date firstTime,long period) 计划时间早于当前时间： 提前执行的效果--立即执行
	
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
