package Chapter2.Test;

import Chapter2.Object.Object2_11;
import Chapter2.Object.Util1;
import Chapter2.Thread.Thread2_11A;
import Chapter2.Thread.Thread2_11B;

public class Test2_11 {
	//synchronized(this)���ͬ�������ı׶�
	
	/**һ���̷߳���object��һ��synchronizedͬ�������ʱ��
	 * ��һ���߳���Ȼ���Է��ʸö����еķ�synchronized����
	 * 
	 * 
	 */
	
	public static void main(String[] args) {
		Object2_11 obj=new Object2_11();
		Thread2_11A thread1=new Thread2_11A(obj);
		thread1.start();
		Thread2_11B thread2=new Thread2_11B(obj);
		thread2.start();
		try{
			Thread.sleep(10000);
		}catch(InterruptedException e){
			e.printStackTrace();
		}
		long begin=Util1.beginTime1;            //��ȡ���翪ʼ��ʱ��
		if(Util1.beginTime1>Util1.beginTime2){
			begin=Util1.beginTime2;
		}
		
		long end=Util1.beginTime1;
		if(Util1.endTime2>Util1.endTime1){
			end=Util1.endTime2;
		}
		
		System.out.println("��ʱ"+(end-begin)/1000+"��");
	}
}
