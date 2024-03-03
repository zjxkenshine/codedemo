package Chapter2.Object;

public class Object2_15_1 {
	//将任意非this对象作为【对象监视器】
	
	private String username;
	private String password;
	private String anyString=new String();
	
	public void setUsernamePassword(String username,String password){
		try{
			synchronized(anyString){
				System.out.println("线程名称为："+Thread.currentThread().getName()+"在"+System.currentTimeMillis()+"进入同步块");
				this.username=username;
				Thread.sleep(2000);
				this.password=password;
				System.out.println("线程名称为："+Thread.currentThread().getName()+"在"+System.currentTimeMillis()+"离开同步块");
			}
		}catch(InterruptedException e){
			e.printStackTrace();
		}
	}

}
