package Chapter5.Test;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;


public class Test5_12 {
	//����schedule(TimeTask task,long delay,long period)����
	
	/**
	 * ����schedule(TimeTask task,long delay,long period)�������Ǵ�ִ�з������delay�����ʼ
	 * ��period����Ϊ�������޴ε�ѭ��ִ��task����
	 */
	
	static public class MyTsk extends TimerTask{
		@Override
		public void run() {
			// TODO Auto-generated method stub
			System.out.println("�����ˣ�ʱ��Ϊ��"+new Date());
		}
	}
	
	public static void main(String[] args) {
		MyTsk tsk=new MyTsk();
		Timer time=new Timer();
		System.out.println("��ǰʱ�䣺"+new Date().toLocaleString());
		time.schedule(tsk, 5000,1000);    //5�����һ��Ϊ��������ѭ��ִ��
	}

}
