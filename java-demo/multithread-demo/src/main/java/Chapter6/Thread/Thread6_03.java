package Chapter6.Thread;

import Chapter6.Object.Object6_03;

public class Thread6_03 extends Thread{
	//延迟加载/懒汉模式解析
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		System.out.println(Object6_03.getInstance().hashCode());
	}

}
