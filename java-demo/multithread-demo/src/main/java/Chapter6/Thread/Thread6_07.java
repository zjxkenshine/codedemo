package Chapter6.Thread;

import Chapter6.Object.Object6_07;

public class Thread6_07 extends Thread{
	//�ӳټ���/����ģʽ��ȱ��Ľ������3������ͬ��,�����Ҫ����ͬ��
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		System.out.println(Object6_07.getInstance().hashCode());
	}


}
