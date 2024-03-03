package Chapter5.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class Test5_10 {
	//Timer���е�cancel()������ע������
	
	/**
	 * Timer���е�cancel()��������ʱ��һ����ִֹͣ�мƻ����Ǽ���ִ��
	 * 
	 * ��ΪTimer���е�cancel()������ʱ��û������queue������������TimeTask�е���������ִ����
	 */
	
	static int i=0;
	static public class Mtsk extends TimerTask{
		@Override
		public void run() {
			// TODO Auto-generated method stub
			System.out.println("����ִ����"+i);
		}
	}
	
	public static void main(String[] args) {
		while(true){
			try{
				i++;
				Timer timer=new Timer();
				Mtsk tsk=new Mtsk();
				SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				String dString="2017-10-11 19:20:00";
				Date d1=sdf.parse(dString);
				timer.schedule(tsk, d1);
				timer.cancel();
				
			}catch (ParseException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
	}

}
