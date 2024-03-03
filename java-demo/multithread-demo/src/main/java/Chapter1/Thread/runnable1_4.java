package Chapter1.Thread;

public class runnable1_4 implements Runnable{
	//线程的另一种实现方式：实现runnable接口
	//Thread类也是通过实现该接口
	public void run(){
		System.out.println("runnable线程运行中");
	}
}
