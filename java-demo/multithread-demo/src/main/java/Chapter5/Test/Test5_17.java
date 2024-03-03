package Chapter5.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;


public class Test5_17 {
	//���Է���scheduleAtFixedRate������ʱ
	
	/**��5_15�Ա�
	 * ����ʱ������£�scheduleAtFixedRate��һ��ִ�������ʱ������һ�����������ʱ��
	 * 
	 */
	
	private static Timer timer=new Timer();
	
	private static int runCount=0;
	
	static public class MyStack extends TimerTask{
		@Override
		public void run() {
			try {
			// TODO Auto-generated method stub
			System.out.println("����ʼִ�У�ʱ��Ϊ"+new Date());
			Thread.sleep(2000);
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
		
		timer.scheduleAtFixedRate(mtsk, day,1000);          //scheduleAtFixedRate���Ϊ1�룬�߳�����2��      
		
		}catch (ParseException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}

}
