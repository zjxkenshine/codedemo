package Chapter6.Thread;

import Chapter6.Object.Object6_02;

public class Thread6_02 extends Thread{
	//��������/����ģʽ
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		System.out.println(Object6_02.getInstance().hashCode());
	}

}
