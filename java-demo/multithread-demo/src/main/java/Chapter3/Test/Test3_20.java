package Chapter3.Test;

import Chapter3.Thread.Thread3_20B;
import Chapter3.Thread.Thread3_20C;

public class Test3_20 {
	//����join��interrupt�쳣
	
	/**
	 * join()��interrupt()��������ʹ�ã�������쳣������û�г����쳣���߳̿��Լ�������
	 */
	
	public static void main(String[] args) {
		try{
			Thread3_20B tb=new Thread3_20B();
			tb.start();
			Thread.sleep(500);
			Thread3_20C tc=new Thread3_20C(tb);
			tc.start();
		}catch (InterruptedException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
