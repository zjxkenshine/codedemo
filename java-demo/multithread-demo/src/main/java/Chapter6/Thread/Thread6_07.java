package Chapter6.Thread;

import Chapter6.Object.Object6_07;

public class Thread6_07 extends Thread{
	//延迟加载/懒汉模式的缺点的解决方法3：部分同步,针对重要代码同步
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		System.out.println(Object6_07.getInstance().hashCode());
	}


}
