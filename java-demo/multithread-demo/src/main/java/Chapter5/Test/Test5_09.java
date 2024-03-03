package Chapter5.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class Test5_09 {
	//schedule(TimeTask task,Date firstTime,long period) --Timer���е�cancel()����
	
	/**
	 * ��TimerTask���е�cancel()�����������ͬ��Timer���е�cancel()�����������ǽ���������е������������
	 */
	
	private static Timer timer=new Timer();
	
	static public class MyTsk1 extends TimerTask{
		@Override
		public void run() {
			// TODO Auto-generated method stub
			System.out.println("�߳�1�����ˣ�ʱ��Ϊ��"+new Date());
			timer.cancel();
		}
	}
	
	static public class MyTsk2 extends TimerTask{
		@Override
		public void run() {
			// TODO Auto-generated method stub
			System.out.println("�߳�2�����ˣ�ʱ��Ϊ��"+new Date());
		}
	}
	
	public static void main(String[] args) {
		try{
			MyTsk1 t1=new MyTsk1();
			MyTsk2 t2=new MyTsk2();
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String dString="2017-10-11 17:52:00";
			Date d1=sdf.parse(dString);
			System.out.println("ִ��ʱ��"+d1.toLocaleString()+"����ʱ��"+new Date().toLocaleString());
		//	Timer timer=new Timer();         //�������򲻻�ֹͣ�����ö���
			timer.schedule(t1, d1,4000);
			timer.schedule(t2, d1,4000);
		}catch (ParseException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	

}
