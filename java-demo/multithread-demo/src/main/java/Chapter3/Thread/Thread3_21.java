package Chapter3.Thread;

public class Thread3_21 extends Thread{
	//方法join(long)的使用
	
	
	public void run(){
		// TODO Auto-generated method stub
		try{
			System.out.println("begin time="+System.currentTimeMillis());
			Thread.sleep(5000);
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

}
