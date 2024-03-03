package Chapter2.Thread;

import Chapter2.Object.Object2_24;

public class Thread2_24 implements Runnable{
	//多线程的死锁
	
	//死锁线程测试用例
	
	public String username;                //判断字符串
	public Object2_24 obj1=new Object2_24();
	public Object2_24 obj2=new Object2_24();
	public void setFlag(String username){
		this.username=username;
	}
	

	@Override
	public void run() {
		// TODO Auto-generated method stub
		if(username.equals("a")){
			synchronized(obj1){
				try{
					System.out.println("username="+username);
					Thread.sleep(3000);
				}catch(InterruptedException e){
					e.printStackTrace();
				}
				synchronized (obj2) {
					System.out.println("按从a到b代码顺序执行了");
				}
			}
		}
		
		if(username.equals("b")){
			synchronized(obj2){
				try{
					System.out.println("username="+username);
					Thread.sleep(3000);
				}catch(InterruptedException e){
					e.printStackTrace();
				}
				synchronized (obj1) {
					System.out.println("按从b到a代码顺序执行了");
				}
			}
		}
		
	}


}
