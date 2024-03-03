package Chapter4.Thread;

import Chapter4.Object.Service4_05;

public class Thread4_05B extends Thread{
	//使用多个Condition实现通知部分线程时的错误用法
	
private Service4_05 ser=new Service4_05();
	
	public Thread4_05B(Service4_05 ser) {
		// TODO Auto-generated constructor stub
		this.ser=ser;
	}
	
@Override
public void run() {
	// TODO Auto-generated method stub
	super.run();
	ser.awaitB();
}


}
