package Chapter4.Test;

import Chapter4.Object.Service4_08;
import Chapter4.Thread.Thread4_08A;
import Chapter4.Thread.Thread4_08B;

public class Test4_08 {
	//ʵ��������/������ģʽ����Զ��ӡ
	
	/**
	 * ���ܻ����������ӡ�����,ԭ����ֻʹ����һ��condition����
	 */
	
	public static void main(String[] args) {
		Service4_08 ser=new Service4_08();
		Thread4_08A[] t1=new Thread4_08A[10];
		Thread4_08B[] t2=new Thread4_08B[10];
		for(int i=0;i<10;i++){
			t1[i]=new Thread4_08A(ser);
			t2[i]=new Thread4_08B(ser);
			t1[i].start();
			t2[i].start();
		}
		
	}

}
