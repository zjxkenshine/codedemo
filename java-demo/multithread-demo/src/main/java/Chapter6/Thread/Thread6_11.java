package Chapter6.Thread;

import Chapter6.Object.Object6_11;

public class Thread6_11 extends Thread{
	//使用static代码实现单例模式
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		System.out.println(Object6_11.get().hashCode());
	}

}
