package Chapter3.Test;

import Chapter3.Thread.Thread3_22A;
import Chapter3.Thread.Thread3_22B;
import Chapter3.Thread.Thread3_22C;

public class Test3_22 {
	// join(long)��sleep(long)������
	
	/**join(long):�ڲ�wait(long)ʵ�֣�ִ�к�ǰ�����ͷţ������߳̿��Ե��ô��߳��е�ͬ������
	 * Thread.sleep(long):���ͷ���
	 * 
	 */
	
	public static void main(String[] args) {
		try{
			Thread3_22B tb=new Thread3_22B();
			Thread3_22A ta=new Thread3_22A(tb);
			ta.start();
			Thread.sleep(2000);
			Thread3_22C tc=new Thread3_22C(tb);
			tc.start();
		}catch (InterruptedException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
