package Chapter3.Test;

import Chapter3.Thread.Thread3_19;

public class Test3_19 {
	//ʹ��join()����
	
	/** 1.����join�������Ƕ��������̶߳���x����ִ��run()�����е����񣬶�ʹ��ǰ�߳�z��������
	 *    �ȴ��߳�x���ٺ�
	 * 
	 * 2.join����ʹ�߳��Ŷӵ����ã���synchronized��ͬ��
	 * 		join�������ڲ�ʹ��wait()�������еȴ���
	 *      ��synchronize�ؼ���ʹ�õ���"���������"ԭ�����ͬ��
	 * 
	 */
	
	public static void main(String[] args) {
		try{
			Thread3_19 t1=new Thread3_19();
			t1.start();
			t1.join();
			System.out.println("���뵱Thread3_18ִ�к���ִ�к���Ĵ���");
			System.out.println("���������sleep�е�ֵ��ȷ��");
			
		}catch(InterruptedException e){
			e.printStackTrace();
		}
		
		
	}

}
