package Chapter6.Test;

import Chapter6.Thread.Thread6_08;

public class Test6_08 {
	//�ӳټ���/����ģʽ��ȱ��Ľ������4��DCL˫���������(Double-Check Locking)
	
	public static void main(String[] args) {
		Thread6_08 t1=new Thread6_08();
		Thread6_08 t2=new Thread6_08();
		Thread6_08 t3=new Thread6_08();
		
		t1.start();
		t2.start();
		t3.start();
		
	}

	
	

}
