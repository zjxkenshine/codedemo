package Chapter2.Thread;

import Chapter2.Object.Object2_20_2;

public class Thread2_20_2C extends Thread{
	//��̬ͬ��synchronized����2
	
	Object2_20_2 obj=new Object2_20_2();
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		obj.MethodC();
	}
	
	

}
