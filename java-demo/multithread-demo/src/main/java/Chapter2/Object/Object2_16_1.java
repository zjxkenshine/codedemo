package Chapter2.Object;

import java.util.ArrayList;
import java.util.List;

public class Object2_16_1 {
	//synchronized(任意非this对象x)解决脏读问题
	
	private List list=new ArrayList();
	
	synchronized public void add(String username){
		System.out.println("ThreadName="+Thread.currentThread().getName()+"执行了add方法");
		list.add(username);
		System.out.println("ThreadName="+Thread.currentThread().getName()+"退出了add方法");
	}

}
