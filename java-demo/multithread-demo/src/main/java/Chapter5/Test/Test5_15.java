package Chapter5.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;


public class Test5_15 {
	//测试schedule方法任务延时
	
	/*
	 * 在延时的情况下，schedule下一次执行任务的时间是上一次任务结束的时间
	 */
	
	private  static Timer timer=new Timer(false);
	
	private static int runCount=0;
	
	static public class MyStack extends TimerTask{
		@Override
		public void run() {
			try {
			// TODO Auto-generated method stub
			System.out.println("任务开始执行，时间为"+new Date());
			Thread.sleep(4000);
			System.out.println("任务执行结束，时间为"+new Date());
			runCount++;
			if(runCount==5){
				timer.cancel();
			}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		try{
		MyStack mtsk=new MyStack();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String start="2017-10-11 20:29:00";
		Date day=sdf.parse(start);
		System.out.println("起始时间为"+day.toLocaleString()+"当前时间"+new Date().toLocaleString());
		
		timer.schedule(mtsk, day, 1000);          //间隔为1秒，线程运行4秒---1秒失去意义      
		
		}catch (ParseException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}

}
