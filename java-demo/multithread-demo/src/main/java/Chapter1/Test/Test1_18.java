package Chapter1.Test;

import Chapter1.Thread.Thread1_18_1;
import Chapter1.Thread.Thread1_18_2;

public class Test1_18 {
	//�쳣��ֹͣ�̣߳��Ƽ���
	
	public static void main(String[] args) {
		try{
		//	Thread1_18_1 thread=new Thread1_18_1();  //break
			Thread1_18_2 thread=new Thread1_18_2();  //throw new exception �����쳣
			thread.start();
			Thread.sleep(10);
			thread.interrupt();
		}catch(InterruptedException e){
			System.out.println("main catch");
			e.printStackTrace();
		}
		System.out.println("end!");
	}
	
}
