package Chapter5.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class Test5_04_1 {
	//����schedule(TimeTask task,Date time) ���TimerTask������ʱ�Ĳ���
	
	/**
	 * TimerTask���Զ��еķ�ʽһ��һ����˳��ִ�У�����ִ�е�ʱ���п��ܺ�Ԥ�Ƶ�ʱ�䲻һ��
	 * ǰ��������ʱ���ܽϳ����������������е�ʱ��Ҳ�ᱻ�ӳ�
	 */
	
	private static Timer timer=new Timer();
	
	static public class Tsk1 extends TimerTask{
		@Override
		public void run() {
			// TODO Auto-generated method stub
			System.out.println("tsk1������,ʱ��Ϊ"+System.currentTimeMillis());
		}
	}
	
	static public class Tsk2 extends TimerTask{
		@Override
		public void run() {
			// TODO Auto-generated method stub
			System.out.println("tsk2������,ʱ��Ϊ"+System.currentTimeMillis());
		}
	}
	
	
	public static void main(String[] args) {
		try{
			Tsk1 tsk1=new Tsk1();
			Tsk2 tsk2=new Tsk2();
			SimpleDateFormat sdf1=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			SimpleDateFormat sdf2=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String day1="2017-10-10 21:49:00";
			String day2="2017-10-10 21:49:10";
			
			Date d1=sdf1.parse(day1);
			Date d2=sdf2.parse(day2);
			
			System.out.println("�ַ���1ִ��ʱ�䣺"+d1.toLocaleString()+" ��ǰ��ʱ�䣺"+new Date().toLocaleString());
			System.out.println("�ַ���2ִ��ʱ�䣺"+d1.toLocaleString()+" ��ǰ��ʱ�䣺"+new Date().toLocaleString());
			
			timer.schedule(tsk1, d1);
			timer.schedule(tsk2, d2);
			
		}catch (ParseException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
