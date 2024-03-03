package Chapter2.Test;

import Chapter2.Object.Object2_19;
import Chapter2.Object.Service2_19;
import Chapter2.Thread.Thread2_19A;
import Chapter2.Thread.Thread2_19B;

public class Test2_19 {
	//synchronized(任意非this对象x)结论验证3：       当其他线程执行x对象中的synchronized(this)同步代码块时呈同步效果
	//如果其他线程调用不加synchronized方法时还是异步执行
	
	public static void main(String[] args) throws InterruptedException {
		Service2_19 serv=new Service2_19();
		Object2_19 obj=new Object2_19();
		Thread2_19A a=new Thread2_19A(serv, obj);
		a.setName("AAAA");
		a.start();
		Thread.sleep(100);
		Thread2_19B b=new Thread2_19B(obj);
		b.setName("BBBB");
		b.start();
	}

}
