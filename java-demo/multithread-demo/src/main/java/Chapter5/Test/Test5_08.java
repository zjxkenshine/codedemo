package Chapter5.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class Test5_08 {
	//TimerTask���е�cancel()����
	
	/**
	 * TimerTask���е�cancel()�����������ǽ��Լ���������������
	 * 
	 */
	
	static public class MyTsk1 extends TimerTask{
		@Override
		public void run() {
			// TODO Auto-generated method stub
			System.out.println("����1ִ���ˣ�ʱ��"+new Date());
			this.cancel();
		}
	}
	
	static public class MyTsk2 extends TimerTask{
		@Override
		public void run() {
			// TODO Auto-generated method stub
			System.out.println("����2ִ���ˣ�ʱ��"+new Date());
		}
	}
	
	public static void main(String[] args) {
		try{
			MyTsk1 t1=new MyTsk1();
			MyTsk2 t2=new MyTsk2();
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String dString="2017-10-11 13:00:00";
			Date d1=sdf.parse(dString);
			System.out.println("ִ��ʱ��"+d1.toLocaleString()+"����ʱ��"+new Date().toLocaleString());
			Timer timer=new Timer();
			timer.schedule(t2, d1,4000);
			timer.schedule(t1, d1,4000);
		}catch (ParseException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
