package Chapter3.Test;

import Chapter3.Object.C3_09;
import Chapter3.Object.P3_09;
import Chapter3.Thread.Thread3_09A;
import Chapter3.Thread.Thread3_09B;

public class Test3_09 {
	//һ��������һ�����ߣ�������ֵ��
	
	//wait/notifyģʽ���İ���
	
	//�����set��get�������
	public static void main(String[] args) {
		String lock=new String("");
		C3_09 c=new C3_09(lock);
		P3_09 p=new P3_09(lock);
		Thread3_09A t1=new Thread3_09A(p);
		Thread3_09B t2=new Thread3_09B(c);
		t1.start();
		t2.start();
	}
	
	
	

}
