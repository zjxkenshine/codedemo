package Chapter2.Object;

public class Object2_05 {
	// 脏读（dirtyRead）
	
	public String username="A";
	public String password="AAA";
	synchronized public void setValue(String username,String password){
		try{
			this.username=username;
			Thread.sleep(5000);
			this.password=password;
			System.out.println("setValue method thread name="+Thread.currentThread().getName()+"  username="+username+", password="+password);
		}catch(InterruptedException e){
			e.printStackTrace();
		}
	}
	
	synchronized public void getValue(){              //取值方法不同步可以在任何时候调用导致脏读,解决方法加上synchronized
		System.out.println("getValue method thread name="+Thread.currentThread().getName()+"  username="+username+", password="+password);
	}
	
}
