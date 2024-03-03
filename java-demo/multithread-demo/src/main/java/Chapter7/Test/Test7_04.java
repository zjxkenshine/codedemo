package Chapter7.Test;

import Chapter7.Thread.Thread7_04;

public class Test7_04 {
	//验证WAITING状态
	
	public static void main(String[] args) {
		try{
			Thread7_04 t1=new Thread7_04();
			t1.start();
			Thread.sleep(1000);
			System.out.println("main方法中的t1状态："+t1.getState());
		}catch (InterruptedException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
