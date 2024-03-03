package Chapter6.Thread;

import Chapter6.Object.Object6_02;

public class Thread6_02 extends Thread{
	//立即加载/饿汉模式
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		System.out.println(Object6_02.getInstance().hashCode());
	}

}
