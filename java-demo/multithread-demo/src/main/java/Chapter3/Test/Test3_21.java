package Chapter3.Test;

import Chapter3.Thread.Thread3_21;

public class Test3_21 {
	//方法join(long)的使用
	
	/**
	 * 本例使用join(2000)与sleep(2000)效果一样
	 * @param args
	 */
	
	public static void main(String[] args) {
		try{
			Thread3_21 t1=new Thread3_21();
			t1.start();
		//	Thread.sleep(2000);
			t1.join(2000);
			System.out.println("end Time="+System.currentTimeMillis());
		}catch(InterruptedException e){
			e.printStackTrace();
		}
	}

}
