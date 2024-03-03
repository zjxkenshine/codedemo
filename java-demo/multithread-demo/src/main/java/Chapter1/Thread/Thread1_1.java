package Chapter1.Thread;

public class Thread1_1 extends Thread {
	//调用的随机性测试
	public void run(){
		super.run();
		System.out.println("调用Thread1-1");
	}
}
