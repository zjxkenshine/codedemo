package Chapter6.Thread;

import Chapter6.Object.Object6_06;

public class Thread6_06 extends Thread{
	//�ӳټ���/����ģʽ��ȱ��Ľ������2��ʹ��ͬ�������
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		System.out.println(Object6_06.getInstance().hashCode());
	}

}
