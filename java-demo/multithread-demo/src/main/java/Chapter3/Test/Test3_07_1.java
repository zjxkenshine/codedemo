package Chapter3.Test;

public class Test3_07_1 {
	//֪ͨ����
	
	private String lock=new String("");
	
	private Runnable runnable1=new Runnable() {
		
		@Override
		public void run() {
			// TODO Auto-generated method stub
			try{
				synchronized (lock) {
				   System.out.println("begin wait");
				   lock.wait();
				   System.out.println("end wait");
				}
			}catch(InterruptedException e){
				e.printStackTrace();
			}
		}
	};
	
	private Runnable runnable2=new Runnable() {
		
		@Override
		public void run() {
			// TODO Auto-generated method stub
			try{
				synchronized (lock) {
				   System.out.println("begin notify");
				   lock.notify();
				   System.out.println("end notify");
				}
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	};
	
	public static void main(String[] args) {
		Test3_07_1 test=new Test3_07_1();
		Thread t1=new Thread(test.runnable1);
		t1.start();
		//Thread.sleep(100);     //��t1t2������sleep����ִ��ntify�����߳�һֱ�ڵȴ�
		Thread t2=new Thread(test.runnable2);
		t2.start();
	}

}

