package Chapter2.Test;

import Chapter2.Object.Object2_15_2;
import Chapter2.Thread.Thread2_15_2A;
import Chapter2.Thread.Thread2_15_2B;
import Chapter2.Thread.Thread2_15_2C;

public class Test2_15_2 {
	//将任意非this对象作为【对象监视器】
	
	/**使用synchronized(this)进行同步时，对象监视器必须是同一个对象，否则运行结果为异步
	 * 
	 * 
	 */
	
	public static void main(String[] args) {
		Object2_15_2 obj=new Object2_15_2();
		Thread2_15_2A a=new Thread2_15_2A(obj);
		a.start();
		Thread2_15_2B b=new Thread2_15_2B(obj);
		b.start();
		Thread2_15_2C c=new Thread2_15_2C(obj);
		c.start();
	}

}
