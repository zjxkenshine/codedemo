package Chapter2.Thread;

import Chapter2.Object.Object2_06_2S;

public class Thread2_06_2 extends Thread{
	//synchronized��������,�̳л���
	@Override
	public void run() {
		Object2_06_2S son=new Object2_06_2S();
		son.MethodA();
	}
}
