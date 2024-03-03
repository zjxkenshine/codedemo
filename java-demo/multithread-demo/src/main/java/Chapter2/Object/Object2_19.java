package Chapter2.Object;

public class Object2_19 {
	//synchronized(任意非this对象x)结论验证3：       当其他线程执行x对象中的synchronized(this)同步代码块时呈同步效果
	
	public void MethodA(){
		synchronized (this) {
			System.out.println("object对象方法MethodA 得到锁 时间："+System.currentTimeMillis()+"运行线程="+Thread.currentThread().getName());
			System.out.println("------------------------------------------------");
			System.out.println("object对象方法MethodA 释放锁 时间："+System.currentTimeMillis()+"运行线程="+Thread.currentThread().getName());
		}
	}


}
