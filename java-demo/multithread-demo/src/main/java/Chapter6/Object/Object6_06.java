package Chapter6.Object;

public class Object6_06 {
	//延迟加载/懒汉模式的缺点的解决方法2：使用同步代码块
	
	private static Object6_06 obj=new Object6_06();
	
	public Object6_06() {
		// TODO Auto-generated constructor stub
	}
	
	public static Object6_06 getInstance(){
		try{
			synchronized (Object6_06.class) {
				if(obj!=null){
					
				}else{
					Thread.sleep(3000);
					obj=new Object6_06();
				}
			}
			
		}catch (InterruptedException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return obj;
	}

}
