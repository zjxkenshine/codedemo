package Chapter1.Test;


import Chapter1.Thread.Thread1_12;

public class Test1_12 {
	//isAlive()�ĸ��������this.isAlive()
	
	public static void main(String[] args) {
		Thread1_12 thread=new Thread1_12();   //δ�������߳�δ���
		thread.start();						//ֻ�д�ʱthis.Alive()Ϊtrue
		Thread t=new Thread(thread);           //��thread����tִ��
		System.out.println("begin t isAlive "+t.isAlive());
		t.setName("A");
		t.start();
		System.out.println("end t isAlive "+t.isAlive());
	}

}
