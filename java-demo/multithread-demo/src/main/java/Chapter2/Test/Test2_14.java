package Chapter2.Test;

import Chapter2.Object.Object2_14;
import Chapter2.Thread.Thread2_14A;
import Chapter2.Thread.Thread2_14B;

public class Test2_14 {
	//验证synchronized代码块是锁定当前对象的
	
	public static void main(String[] args) {
		Object2_14 obj= new Object2_14();
		Thread2_14B b=new Thread2_14B(obj);
		b.start();
		Thread2_14A a=new Thread2_14A(obj);
		a.start();
	}
	
	

}
