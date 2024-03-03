package Chapter6.Thread;

import Chapter6.Object.Object6_08;

public class Thread6_08 extends Thread{
	//延迟加载/懒汉模式的缺点的解决方法4：DCL双检查锁机制(Double-Check Locking)
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		System.out.println(Object6_08.getInstance().hashCode());
	}

}
