package Chapter5.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class Test5_09 {
	//schedule(TimeTask task,Date firstTime,long period) --Timer类中的cancel()方法
	
	/**
	 * 和TimerTask类中的cancel()方法清除自身不同，Timer类中的cancel()方法的作用是将任务队列中的所有任务清空
	 */
	
	private static Timer timer=new Timer();
	
	static public class MyTsk1 extends TimerTask{
		@Override
		public void run() {
			// TODO Auto-generated method stub
			System.out.println("线程1运行了，时间为："+new Date());
			timer.cancel();
		}
	}
	
	static public class MyTsk2 extends TimerTask{
		@Override
		public void run() {
			// TODO Auto-generated method stub
			System.out.println("线程2运行了，时间为："+new Date());
		}
	}
	
	public static void main(String[] args) {
		try{
			MyTsk1 t1=new MyTsk1();
			MyTsk2 t2=new MyTsk2();
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String dString="2017-10-11 17:52:00";
			Date d1=sdf.parse(dString);
			System.out.println("执行时间"+d1.toLocaleString()+"现在时间"+new Date().toLocaleString());
		//	Timer timer=new Timer();         //这句加上则不会停止，重置对象
			timer.schedule(t1, d1,4000);
			timer.schedule(t2, d1,4000);
		}catch (ParseException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	

}
