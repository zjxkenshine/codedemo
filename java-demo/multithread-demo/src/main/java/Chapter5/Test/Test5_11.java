package Chapter5.Test;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class Test5_11 {
	//����schedule(TimeTask task,long delay)����
	
	/**
	 * �÷�������������ִ��schedule(TimeTask task,long delay)��ʱ��Ϊ�ο�ʱ�䣬
	 * ���ӳ�delay�����ִ��һ��task����
	 */
	
	static public class MyTask extends TimerTask{
		@Override
		public void run() {
			// TODO Auto-generated method stub
			System.out.println("������,ʱ��Ϊ:"+new Date());
		}
	}
	
	public static void main(String[] args) {
		MyTask tsk=new MyTask();
		Timer time=new Timer();
		System.out.println("��ǰʱ�䣺"+new Date().toLocaleString());
		time.schedule(tsk, 5000);
		
	}

}
