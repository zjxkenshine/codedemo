package Chapter3.Test;

import Chapter3.Thread.Thread3_25_2A;
import Chapter3.Thread.Thread3_25_2B;

public class Test3_25_2 {
	//��֤�̱߳����ĸ�����
	
	public static void main(String[] args) {
		try{
			Thread3_25_2A t1=new Thread3_25_2A();
			t1.start();
			Thread.sleep(1000);
			Thread3_25_2B t2=new Thread3_25_2B();
			t2.start();
			
		}catch (InterruptedException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
