package Chapter5.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;


public class Test5_19 {
	//验证scheduleAtFixedRate具有任务追赶性
	
	/**
	 * scheduleAtFixedRate具有任务追赶性,会补充性得执行前面时间段内所对应的任务
	 */
	
	private static Timer timer=new Timer();
	
	static public class MyTask extends TimerTask{
		@Override
		public void run() {
			// TODO Auto-generated method stub
			System.out.println("1 begin 运行了，时间为"+new Date());
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("1 end   运行了，时间为"+new Date());
		}
	}
	
	public static void main(String[] args) {
		try{
			MyTask stk=new MyTask();
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String dString ="2018-03-05 23:11:00";
			Date day=sdf.parse(dString);
			System.out.println("开始时间"+day.toLocaleString()+"当前时间"+new Date().toLocaleString());
			
			timer.scheduleAtFixedRate(stk, day, 5000);
			
		}catch (ParseException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
