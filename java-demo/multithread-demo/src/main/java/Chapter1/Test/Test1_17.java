package Chapter1.Test;

import Chapter1.Thread.Thread1_17;

public class Test1_17 {
	//this.isInterrupted():�Ǿ�̬�����������̶߳��󣨷ǵ�ǰ�̣߳��Ƿ��жϣ���������ж�״̬���
	public static void main(String[] args) {
		try{
			Thread1_17 thread=new Thread1_17();
			thread.setName("A");
			thread.start();
			Thread.sleep(10);
			thread.interrupt();
			System.out.println(thread.getName()+"�Ƿ�ֹͣ1��="+thread.isInterrupted());    
			System.out.println(thread.getName()+"�Ƿ�ֹͣ2��="+thread.isInterrupted());
			//�����thread���жϱ�ǣ������̻߳����ִ��
		}catch(InterruptedException e){
			System.out.println("main catch");
			e.printStackTrace();
		}
		System.out.println("end!");
	}

}
