package Chapter4.Thread;

import Chapter4.Object.Service4_06;

public class Thread4_06A extends Thread{
	//��ȷʹ�ö��Conditionʵ��֪ͨ�����߳�
	private Service4_06 ser=new Service4_06();
	
	public Thread4_06A(Service4_06 ser){
		super();
		this.ser=ser;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		ser.awaitA();
	}

}
