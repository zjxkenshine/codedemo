package Chapter7.Test;

import Chapter7.Thread.Thread7_04;

public class Test7_04 {
	//��֤WAITING״̬
	
	public static void main(String[] args) {
		try{
			Thread7_04 t1=new Thread7_04();
			t1.start();
			Thread.sleep(1000);
			System.out.println("main�����е�t1״̬��"+t1.getState());
		}catch (InterruptedException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
