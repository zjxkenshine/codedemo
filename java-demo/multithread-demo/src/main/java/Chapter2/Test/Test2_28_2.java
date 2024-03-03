package Chapter2.Test;

import Chapter2.Object.Object2_28_2;
import Chapter2.Object.Userinfo2_28_2;
import Chapter2.Thread.Thread2_28_2A;
import Chapter2.Thread.Thread2_28_2B;

public class Test2_28_2 {
	//锁对象的改变
	
	/**
	 * 只要对象不变，即使对象的属性改变，运行结果还是同步的
	 */
	
	public static void main(String[] args) {
		try {
			Object2_28_2 obj=new Object2_28_2();
			Userinfo2_28_2 info=new Userinfo2_28_2();
			Thread2_28_2A a=new Thread2_28_2A(obj, info);
			a.setName("AAA");
			Thread2_28_2B b=new Thread2_28_2B(obj, info);
			b.setName("BBB");
			a.start();
			Thread.sleep(50);
			b.start();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
