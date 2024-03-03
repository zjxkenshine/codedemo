package Chapter3.Test;

public class Test3_07_2 {
	//过早通知时只执行notify
	
	private boolean isnotify=false;
	
	private String lock=new String("");
	
	private Runnable runnable1=new Runnable() {
		
		@Override
		public void run() {
			// TODO Auto-generated method stub
			try{
				if(!isnotify){
					synchronized (lock) {
					   System.out.println("begin wait");
					   lock.wait();
					   System.out.println("end wait");
					}
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
				   isnotify=true;
				}
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	};
	
	public static void main(String[] args) throws InterruptedException {
		Test3_07_2 test=new Test3_07_2();
		Thread t1=new Thread(test.runnable2);
		t1.start();
		Thread.sleep(100);  
		Thread t2=new Thread(test.runnable1);
		t2.start();
	}

}
