package Chapter3.Thread;

public class Thread3_20B extends Thread{
	//方法join与interrupt异常
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		try{
			Thread3_20A a=new Thread3_20A();
			a.start();
			a.join();
			System.out.println("线程B在run end 处打印");
			
		}catch (InterruptedException e) {
			// TODO: handle exception
			System.out.println("线程B在run catch 处打印");
			e.printStackTrace();
		}
	}

}
