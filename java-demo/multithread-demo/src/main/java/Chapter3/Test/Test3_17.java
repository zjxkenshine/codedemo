package Chapter3.Test;

import Chapter3.Object.Object3_17;
import Chapter3.Thread.Thread3_17A;
import Chapter3.Thread.Thread3_17B;

public class Test3_17 {
	//ʵս���ȴ�/֪ͨ���汸��
	
	/**����20���̣߳�10�������ݿⱸ�ݵ�a���ݿ⣨���������������棩
	 *              10�������ݿⱸ�ݵ�a���ݿ⣨���������������棩
	 */
	
	public static void main(String[] args) {
		Object3_17 obj =new Object3_17();
		
		for(int i=0;i<20;i++){
			Thread3_17A t1=new Thread3_17A(obj);
			t1.start();
			Thread3_17B t2=new Thread3_17B(obj);
			t2.start();
		}
	}

}
