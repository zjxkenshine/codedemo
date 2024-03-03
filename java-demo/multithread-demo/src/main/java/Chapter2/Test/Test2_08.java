package Chapter2.Test;

import Chapter2.Object.Object2_08S;
import Chapter2.Thread.Thread2_08A;
import Chapter2.Thread.Thread2_08B;

public class Test2_08 {
	//同步不具有继承性
	
	public static void main(String[] args) {
		Object2_08S obj=new Object2_08S();
		Thread2_08A a=new Thread2_08A(obj);
		a.setName("A");
		a.start();
		Thread2_08B b=new Thread2_08B(obj);
		b.setName("B");
		b.start();
	}
}
