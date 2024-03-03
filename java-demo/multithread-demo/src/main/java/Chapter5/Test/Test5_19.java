package Chapter5.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;


public class Test5_19 {
	//��֤scheduleAtFixedRate��������׷����
	
	/**
	 * scheduleAtFixedRate��������׷����,�Ჹ���Ե�ִ��ǰ��ʱ���������Ӧ������
	 */
	
	private static Timer timer=new Timer();
	
	static public class MyTask extends TimerTask{
		@Override
		public void run() {
			// TODO Auto-generated method stub
			System.out.println("1 begin �����ˣ�ʱ��Ϊ"+new Date());
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("1 end   �����ˣ�ʱ��Ϊ"+new Date());
		}
	}
	
	public static void main(String[] args) {
		try{
			MyTask stk=new MyTask();
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String dString ="2018-03-05 23:11:00";
			Date day=sdf.parse(dString);
			System.out.println("��ʼʱ��"+day.toLocaleString()+"��ǰʱ��"+new Date().toLocaleString());
			
			timer.scheduleAtFixedRate(stk, day, 5000);
			
		}catch (ParseException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
