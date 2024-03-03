package Chapter5.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class Test5_07 {
	//方法schedule(TimeTask task,Date firstTime,long period) 任务执行时间被延时
	
	static public class MyTask extends TimerTask{
		@Override
		public void run() {
			// TODO Auto-generated method stub
			try{
				System.out.println("A运行了，时间为"+new Date());
				Thread.sleep(5000);
				System.out.println("A运行结束了，时间为"+new Date());
			}catch (InterruptedException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		try{
			MyTask tsk=new MyTask();
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String dString="2018-3-5 12:45:30";
			Timer time=new Timer();
			Date d1=sdf.parse(dString);
			System.out.println("执行时间"+d1.toLocaleString()+"现在时间"+new Date().toLocaleString());
			time.schedule(tsk, d1, 1000);              //1秒循环一次
			
			//会延迟为5秒循环一次
		}catch(ParseException e){
			e.printStackTrace();
		}
	}
	

}
