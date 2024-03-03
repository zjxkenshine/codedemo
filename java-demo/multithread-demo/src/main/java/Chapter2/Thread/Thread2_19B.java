package Chapter2.Thread;

import Chapter2.Object.Object2_19;

public class Thread2_19B extends Thread{
	//synchronized(任意非this对象x)结论验证3：       当其他线程执行x对象中的synchronized(this)同步代码块时呈同步效果
	private Object2_19 obj;
	
	public Thread2_19B(Object2_19 obj) {
		// TODO Auto-generated constructor stub
		super();
		this.obj=obj;;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		obj.MethodA();
	}
	

}
