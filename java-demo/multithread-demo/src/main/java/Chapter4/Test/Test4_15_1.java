package Chapter4.Test;

import Chapter4.Object.Service4_15;
import Chapter4.Thread.Thread4_15A;

public class Test4_15_1 {
	//����awaitUntil()��ʹ��
	
	//�̵߳ȴ���ĳһʱ�̣�������ǰ���Ա�����
	
	public static void main(String[] args) {
		Service4_15 ser=new Service4_15();
		Thread4_15A t1=new Thread4_15A(ser);
		t1.start();
	}

}
