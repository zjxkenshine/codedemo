package Chapter5.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;



public class Test5_18 {
	//验证schedule不具有任务追赶性
	
	/**
	 * 开始时间早于当前时间时，这中间的任务就忽略执行了，这就是schedule不具有任务追赶性
	 */
	
	private static Timer timer=new Timer();
	
	static public class MyTask extends TimerTask{
		@Override
		public void run() {
			// TODO Auto-generated method stub
			System.out.println("1 begin 运行了，时间为"+new Date());
			System.out.println("1 end   运行了，时间为"+new Date());
		}
	}
	
	public static void main(String[] args) {
		try{
			MyTask stk=new MyTask();
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String dString ="2017-10-11 21:00:00";
			Date day=sdf.parse(dString);
			System.out.println("开始时间"+day.toLocaleString()+"当前时间"+new Date().toLocaleString());
			
			timer.schedule(stk, day, 5000);
			
		}catch (ParseException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
