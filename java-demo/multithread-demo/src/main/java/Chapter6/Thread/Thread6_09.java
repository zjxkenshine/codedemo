package Chapter6.Thread;

import Chapter6.Object.Object6_09;

public class Thread6_09 extends Thread{
	//ʹ�þ�̬������ʵ�ֵ���ģʽ
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		System.out.println(Object6_09.getInstance().hashCode());
	}

}
