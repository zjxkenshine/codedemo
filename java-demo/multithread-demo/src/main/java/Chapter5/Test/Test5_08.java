package Chapter5.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class Test5_08 {
	//TimerTask类中的cancel()方法
	
	/**
	 * TimerTask类中的cancel()方法的作用是将自己从任务队列中清除
	 * 
	 */
	
	static public class MyTsk1 extends TimerTask{
		@Override
		public void run() {
			// TODO Auto-generated method stub
			System.out.println("任务1执行了，时间"+new Date());
			this.cancel();
		}
	}
	
	static public class MyTsk2 extends TimerTask{
		@Override
		public void run() {
			// TODO Auto-generated method stub
			System.out.println("任务2执行了，时间"+new Date());
		}
	}
	
	public static void main(String[] args) {
		try{
			MyTsk1 t1=new MyTsk1();
			MyTsk2 t2=new MyTsk2();
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String dString="2017-10-11 13:00:00";
			Date d1=sdf.parse(dString);
			System.out.println("执行时间"+d1.toLocaleString()+"现在时间"+new Date().toLocaleString());
			Timer timer=new Timer();
			timer.schedule(t2, d1,4000);
			timer.schedule(t1, d1,4000);
		}catch (ParseException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
