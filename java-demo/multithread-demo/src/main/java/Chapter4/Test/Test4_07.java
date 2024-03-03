package Chapter4.Test;

import Chapter4.Object.Service4_07;
import Chapter4.Thread.Thread4_07A;
import Chapter4.Thread.Thread4_07B;

public class Test4_07 {
	//实现生产者/消费者模式：一对一打印
	public static void main(String[] args) {
		Service4_07 ser=new Service4_07();
		Thread4_07A t1=new Thread4_07A(ser);
		t1.start();
		Thread4_07B t2=new Thread4_07B(ser);
		t2.start();
	}
	
	

}
