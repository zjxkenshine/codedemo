package Chapter2.Thread;

import Chapter2.Object.Object2_07;

public class Thread2_07A extends Thread{
	//��������쳣ʱ���������е������Զ��ͷ�
	private Object2_07 obj=new Object2_07();
	
	public Thread2_07A(Object2_07 obj){
		super();
		this.obj=obj;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		obj.testMethod();
	}
}
