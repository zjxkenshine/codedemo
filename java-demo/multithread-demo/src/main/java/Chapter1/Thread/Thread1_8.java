package Chapter1.Thread;

public class Thread1_8 extends Thread{
	//i++,i--��println(ͬ������)���ã�������һ���쳣
	private int i=5;
	

	 public void run(){            //�������������synchronized
		super.run();

		System.out.println("���߳�"+this.currentThread().getName()+"���㣬i="+(i--));  //i--��println������ִ��
	}
}
