package Chapter2.Test;

import Chapter2.Object.Object2_12;
import Chapter2.Thread.Thread2_12A;
import Chapter2.Thread.Thread2_12B;

public class Test2_12 {
	//ͬ�������һ��ͬ��һ���첽
	
	/**��synchronized���еĴ���ͬ��ִ�У�����synchronized���еĴ����첽ִ��
	 * 
	 * ͬ���������е�ǰ���ö������(��֤)
	 */
	
	public static void main(String[] args) {
		Object2_12 obj=new Object2_12();
		Thread2_12A thread1=new Thread2_12A(obj);
		thread1.start();
		Thread2_12B thread2=new Thread2_12B(obj);
		thread2.start();
	}
	

}
