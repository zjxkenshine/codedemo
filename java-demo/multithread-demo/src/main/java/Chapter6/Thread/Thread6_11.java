package Chapter6.Thread;

import Chapter6.Object.Object6_11;

public class Thread6_11 extends Thread{
	//ʹ��static����ʵ�ֵ���ģʽ
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		System.out.println(Object6_11.get().hashCode());
	}

}
