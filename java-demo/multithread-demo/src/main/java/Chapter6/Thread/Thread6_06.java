package Chapter6.Thread;

import Chapter6.Object.Object6_06;

public class Thread6_06 extends Thread{
	//延迟加载/懒汉模式的缺点的解决方法2：使用同步代码块
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		System.out.println(Object6_06.getInstance().hashCode());
	}

}
