package Chapter2.Test;

import Chapter2.Object.Object2_35;
import Chapter2.Thread.Thread2_35A;
import Chapter2.Thread.Thread2_35B;

public class Test2_35 {
	//synchronized�������volatileͬ������          
	
	/**
	 * 1.�ؼ���synchronized����ʹ����̷߳���ͬһ����Դ����ͬ���ԣ�
	 * 	   �����������н�˽�б����빮���ڴ��б���ͬ���Ĺ���
	 * 
	 * 2.synchronized���������ԣ������ԣ�������
	 * 
	 * 3.�ؼ���synchronized���Ա�֤��ͬһ��ʱ�̣�ֻ��һ���߳�ִ��ĳһ�����������飬
	 * 	 �����Ա�֤����ͬ����������ͬ��������ÿ���̣߳���������һ��������֮ǰ�������޸�Ч��
	 * 
	 * 4.�������⣬���޿ɼ�
	 * @throws InterruptedException 
	 */
	
	public static void main(String[] args) throws InterruptedException {
		Object2_35 obj=new Object2_35();
		Thread2_35A a=new Thread2_35A(obj);
		a.start();
		Thread.sleep(1000);
		Thread2_35B b=new Thread2_35B(obj);
		b.start();
		System.out.println("�ѷ���ָֹͣ��");
		
	}
	

}
