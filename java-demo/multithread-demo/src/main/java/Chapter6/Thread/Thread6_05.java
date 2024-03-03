package Chapter6.Thread;

import Chapter6.Object.Object6_05;

public class Thread6_05 extends Thread{
	//延迟加载/懒汉模式的缺点的解决方法1：声明synchronize关键字
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		System.out.println(Object6_05.getInstance().hashCode());
	}

}
