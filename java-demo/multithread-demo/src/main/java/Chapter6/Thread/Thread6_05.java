package Chapter6.Thread;

import Chapter6.Object.Object6_05;

public class Thread6_05 extends Thread{
	//�ӳټ���/����ģʽ��ȱ��Ľ������1������synchronize�ؼ���
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		System.out.println(Object6_05.getInstance().hashCode());
	}

}
