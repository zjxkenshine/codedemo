package Chapter1.Thread;

public class Thread1_11 extends Thread{
	//isAlive()�������ж��߳��Ƿ��ڻ״̬
	public void run(){
		System.out.println("run="+this.isAlive());
	}
}
