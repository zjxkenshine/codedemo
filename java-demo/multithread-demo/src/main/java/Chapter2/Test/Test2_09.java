package Chapter2.Test;

import Chapter2.Object.Object2_09;
import Chapter2.Object.Util1;
import Chapter2.Thread.Thread2_09A;
import Chapter2.Thread.Thread2_09B;

public class Test2_09 {
	//synchronized�����ı׶�--��ʱ���Ŷ�
	
	//������ʱ���Ͽ����׶˷ǳ�����
	
	public static void main(String[] args) {
		Object2_09 obj=new Object2_09();
		Thread2_09A thread1=new Thread2_09A(obj);
		thread1.start();
		Thread2_09B thread2=new Thread2_09B(obj);
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
