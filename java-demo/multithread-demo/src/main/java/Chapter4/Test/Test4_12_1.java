package Chapter4.Test;

import Chapter4.Object.Service4_12_1;

public class Test4_12_1 {
	//isFair()����
	
	/**
	 * boolean isFair()�������������ж����ǲ��ǹ�ƽ��
	 * 
	 */
	
	
	public static void main(String[] args) {
		final Service4_12_1 ser=new Service4_12_1(true);
	
		Runnable runn=new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				ser.TestMethod();
			}
		};
		
		Thread thread=new Thread(runn);
		thread.start();
		
		final Service4_12_1 ser2=new Service4_12_1(false);
       Runnable runn2=new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				ser2.TestMethod();
			}
		};
		
		Thread thread2=new Thread(runn2);
		thread2.start();
		
	}
	
	
	

}
