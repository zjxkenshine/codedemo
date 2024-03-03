package Chapter5.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class Test5_07 {
	//����schedule(TimeTask task,Date firstTime,long period) ����ִ��ʱ�䱻��ʱ
	
	static public class MyTask extends TimerTask{
		@Override
		public void run() {
			// TODO Auto-generated method stub
			try{
				System.out.println("A�����ˣ�ʱ��Ϊ"+new Date());
				Thread.sleep(5000);
				System.out.println("A���н����ˣ�ʱ��Ϊ"+new Date());
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
			System.out.println("ִ��ʱ��"+d1.toLocaleString()+"����ʱ��"+new Date().toLocaleString());
			time.schedule(tsk, d1, 1000);              //1��ѭ��һ��
			
			//���ӳ�Ϊ5��ѭ��һ��
		}catch(ParseException e){
			e.printStackTrace();
		}
	}
	

}
