package Chapter4.Test;

import Chapter4.Object.Service4_12_3;

public class Test4_12_3 {
	//isLocked()����
	
	/**
	 *boolean isLocked()������ѯ�Ƿ����̳߳��и�����
	 */
	
	public static void main(String[] args) {
		final Service4_12_3 ser=new Service4_12_3(true);
		
		Runnable runn=new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				ser.TestMethod();
			}
		};
		Thread t1=new Thread(runn);
		t1.start();
	}
	

}
