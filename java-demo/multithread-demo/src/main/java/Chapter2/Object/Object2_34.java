package Chapter2.Object;

import java.util.concurrent.atomic.AtomicLong;

public class Object2_34 {
	//有原子类也并非完全安全
	
	public static AtomicLong along=new AtomicLong();
	
//	synchronized public void addNum(){                 //需要同步,两方法之间不是原子的
	public void addNum(){
		System.out.println(Thread.currentThread().getName()+" 加了100后的值是："+along.addAndGet(100));
		along.addAndGet(1);
	}

}
