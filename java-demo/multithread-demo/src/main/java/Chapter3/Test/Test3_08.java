package Chapter3.Test;

import Chapter3.Object.Add3_08;
import Chapter3.Object.Substract3_08;
import Chapter3.Thread.Thread3_08A;
import Chapter3.Thread.Thread3_08B;

public class Test3_08 {
	//�ȴ�wait�����������仯
	
	//wait�ȴ������������仯��Ҳ������ɳ����߼��Ļ���,����substract����
	
	public static void main(String[] args) throws InterruptedException {
		String lock=new String("");
		Add3_08 add=new Add3_08(lock);
		Substract3_08 sub=new Substract3_08(lock);
		Thread3_08B t1=new Thread3_08B(sub);
		t1.setName("������1");
		t1.start();
		Thread3_08B t2=new Thread3_08B(sub);
		t2.setName("������2");
		t2.start();
		Thread.sleep(1000);
		Thread3_08A t3=new Thread3_08A(add);
		t3.setName("�Ӳ���1");
		t3.start();
	}

}
