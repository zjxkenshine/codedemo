package Chapter6.Thread;

import Chapter6.Object.Object6_12;

public class Thread6_12 extends Thread{
	//	ʹ��enumö����������ʵ�ֵ���ģʽ
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		for(int i=0;i<5;i++){
			System.out.println(Object6_12.connectionFactory.getcon().hashCode());
		}
	}

}
