package Chapter2.Test;

import Chapter2.Object.Object2_29;

public class Test2_29 {
	//volatile�ؼ�������ѭ��
	
	/**1.�����ڶ�̳е�����£�Thread��runnable������һ�����ֶ�̳У���ʹ��Runnable�ӿھͺ��б�Ҫ
	 * 
	 * 2.�������Է��̻߳����µ���ѭ��
	 * 
	 * 3.���Խ��:main�߳���ѭ���������޷�ִ�к���Ĵ���
	 * 
	 * 4.������������߳�
	 */
	
	public static void main(String[] args) {
		Object2_29 obj=new Object2_29();
		obj.MethodA();
		System.out.println("����Aֹͣ��");
		obj.setPrint(false);
	}

}
