package Chapter2.Test;

import Chapter2.Object.Object2_27.InnerClass1;
import Chapter2.Object.Object2_27.InnerClass2;

public class Test2_27 {
	//��������ͬ��ʵ��2
	
	/**
	 * ���ԣ�ͬ�������synchronized(class2)��class2������
	 * 		�����߳�ֻ����ͬ����ʽ����class2�еľ�̬ͬ������
	 * 
	 * ���:����AB��BC�첽,ACͬ��
	 * 
	 */
	
	public static void main(String[] args) {
		final InnerClass1 in1=new InnerClass1();
		final InnerClass2 in2=new InnerClass2();
		
		Thread t1=new Thread(new Runnable(){            //�Ƚϵ���̴߳�������
			public void run() {
				// TODO Auto-generated method stub
				in1.method1(in2);
			}
		},"AAA");
		
		Thread t2=new Thread(new Runnable(){
			public void run() {
				// TODO Auto-generated method stub
				in1.method2();
			}
		},"BBB");
		
		Thread t3=new Thread(new Runnable(){
			public void run() {
				// TODO Auto-generated method stub
				in2.method3();
			}
		},"CCC");
		
		t1.start();
		t2.start();
		t3.start();
		
	}

}
