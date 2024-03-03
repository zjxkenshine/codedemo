package Chapter4.Test;

import Chapter4.Object.Service4_06;
import Chapter4.Thread.Thread4_06A;
import Chapter4.Thread.Thread4_06B;



public class Test4_06 {
	//正确使用多个Condition实现通知部分线程
	
	/**
	 * 实例化多个condition对象
	 * 可以唤醒指定种类的线程
	 * @throws InterruptedException 
	 */
	
	public static void main(String[] args) throws InterruptedException {
		
		Service4_06 ser=new Service4_06();
		
		Thread4_06A a=new Thread4_06A(ser);
		a.setName("A");
		Thread4_06B b=new Thread4_06B(ser);
		b.setName("B");
		a.start();
		b.start();
		Thread.sleep(3000);

		ser.signalA();           //仅唤醒A
	//	ser.signalB();            //仅唤醒B
	}

	

}
