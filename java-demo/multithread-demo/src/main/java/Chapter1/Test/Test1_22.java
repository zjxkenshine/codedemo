package Chapter1.Test;

import Chapter1.Thread.Thread1_22;

public class Test1_22 {
	//��ͣ�̣߳�suspend()����resume()�ָ�
	
	public static void main(String[] args) {
		try{
			Thread1_22 thread=new Thread1_22();
			thread.start();
			Thread.sleep(3000);
			
			//A��
			thread.suspend();  //��ͣ
			System.out.println("A="+System.currentTimeMillis()+"  i="+thread.getI());
			Thread.sleep(3000);
			System.out.println("A="+System.currentTimeMillis()+"  i="+thread.getI());
			
			//B��
			thread.resume();  //�ָ�
			Thread.sleep(3000);
			
			//C��
			thread.suspend(); //��ͣ
			System.out.println("B="+System.currentTimeMillis()+"  i="+thread.getI());
			Thread.sleep(3000);
			System.out.println("B="+System.currentTimeMillis()+"  i="+thread.getI());
			
		}catch(InterruptedException e){
			e.printStackTrace();
		}
	}

}
