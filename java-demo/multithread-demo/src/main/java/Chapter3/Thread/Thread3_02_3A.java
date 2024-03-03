package Chapter3.Thread;

public class Thread3_02_3A extends Thread{
	
	private Object lock;
	public Thread3_02_3A(Object lock) {
		// TODO Auto-generated constructor stub
		super();
		this.lock=lock;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		try{
			synchronized (lock) {
				System.out.println("¿ªÊ¼      wait time ="+System.currentTimeMillis());
				lock.wait();
				System.out.println("½áÊø      wait time ="+System.currentTimeMillis());
			}
		}catch(InterruptedException e){
			e.printStackTrace();
		}
	}

}
