package Chapter5.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;


public class Test5_15 {
	//����schedule����������ʱ
	
	/*
	 * ����ʱ������£�schedule��һ��ִ�������ʱ������һ�����������ʱ��
	 */
	
	private  static Timer timer=new Timer(false);
	
	private static int runCount=0;
	
	static public class MyStack extends TimerTask{
		@Override
		public void run() {
			try {
			// TODO Auto-generated method stub
			System.out.println("����ʼִ�У�ʱ��Ϊ"+new Date());
			Thread.sleep(4000);
			System.out.println("����ִ�н�����ʱ��Ϊ"+new Date());
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
		System.out.println("��ʼʱ��Ϊ"+day.toLocaleString()+"��ǰʱ��"+new Date().toLocaleString());
		
		timer.schedule(mtsk, day, 1000);          //���Ϊ1�룬�߳�����4��---1��ʧȥ����      
		
		}catch (ParseException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}

}
