package Chapter2.Thread;

import Chapter2.Object.Object2_09;
import Chapter2.Object.Util1;

public class Thread2_09A extends Thread{
	//synchronized�����ı׶�--��ʱ���Ŷ�
	
	private Object2_09 obj;
	public Thread2_09A(Object2_09 obj) {
		// TODO Auto-generated constructor stub
		super();
		this.obj=obj;
	}
	
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		Util1.beginTime1=System.currentTimeMillis();
		obj.dolongtask();
		Util1.endTime1=System.currentTimeMillis();
	}
}