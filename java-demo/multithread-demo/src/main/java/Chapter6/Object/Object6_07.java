package Chapter6.Object;

public class Object6_07 {
	//延迟加载/懒汉模式的缺点的解决方法3：部分同步,针对重要代码同步
	
	private static Object6_07 obj;
	
	public Object6_07() {
		// TODO Auto-generated constructor stub
	}
	
	public static Object6_07 getInstance(){
		try{
			if(obj!=null){
			}else{
				Thread.sleep(3000);
				//虽然主要部分线程上锁，但是仍然有非线程安全问题
				
				synchronized (Object6_07.class) {
					obj=new Object6_07();
				}
			}
		}catch (InterruptedException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return obj;
	}

}
