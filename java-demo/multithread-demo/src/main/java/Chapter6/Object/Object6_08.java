package Chapter6.Object;

public class Object6_08 {
	//延迟加载/懒汉模式的缺点的解决方法4：DCL双检查锁机制(Double-Check Locking)
	
	private volatile static Object6_08 obj;
	
	private Object6_08() {
		// TODO Auto-generated constructor stub
	}
	
	

	public static Object6_08 getInstance() {
		// TODO Auto-generated method stub
		try{
			if(obj!=null){
				
			}else{
				Thread.sleep(3000);
				synchronized (Object6_08.class) {
					if(obj==null){
						obj=new Object6_08();
					}
				}
			}
			
		}catch (InterruptedException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return obj;
	}
	

}
