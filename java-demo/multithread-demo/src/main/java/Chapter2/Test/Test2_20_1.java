package Chapter2.Test;

import Chapter2.Thread.Thread2_20_1A;
import Chapter2.Thread.Thread2_20_1B;

public class Test2_20_1 {
	//��̬ͬ��synchronized����1
	
	/**�ؼ���synchronized������Ӧ����static��̬�����ϣ��Ե�ǰ*.java�ļ�����Ӧ��Class�ࡿ���г���
	 * 
	 * ͬ��Ч��
	 */
	
	public static void main(String[] args) {
		Thread2_20_1A thread1=new Thread2_20_1A();
		thread1.setName("AAA");
		thread1.start();
		Thread2_20_1B thread2=new Thread2_20_1B();
		thread2.setName("BBB");
		thread2.start();
	}

}
