package Chapter1.Test;

import Chapter1.Thread.Thread1_23_2;

public class Test1_23_2 {
	//suspend()��resume()ȱ�����ӣ���ռͬ����
	
	public static void main(String[] args) {
		try{
			Thread1_23_2 thread =new Thread1_23_2();
			thread.start();
			Thread.sleep(1000);
			thread.suspend();
			System.out.println("main end!");        //�ᱻprintln��ͬ���������ᱻthread��ռ
			
		}catch(InterruptedException e){
			e.printStackTrace();
		}
	}
}
