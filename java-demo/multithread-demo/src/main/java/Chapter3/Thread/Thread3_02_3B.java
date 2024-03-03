package Chapter3.Thread;

public class Thread3_02_3B extends Thread{
	
	private Object lock;
	public Thread3_02_3B(Object lock) {
		// TODO Auto-generated constructor stub
		super();
		this.lock=lock;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
			synchronized (lock) {
				System.out.println("¿ªÊ¼      notify time ="+System.currentTimeMillis());
				lock.notify();
				System.out.println("½áÊø      notify time ="+System.currentTimeMillis());
			}
		
	}

}
