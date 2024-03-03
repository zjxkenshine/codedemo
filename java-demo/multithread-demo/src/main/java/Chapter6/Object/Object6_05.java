package Chapter6.Object;

public class Object6_05 {
	//延迟加载/懒汉模式的缺点的解决方法1：声明synchronize关键字
	
	private static Object6_05 obj;
	
	public Object6_05() {
		// TODO Auto-generated constructor stub
	}
	
	synchronized public static Object6_05 getInstance(){
		try{
			if(obj!=null){
			}else{
				//模拟创建对象之前做一些准备工作
				Thread.sleep(3000);
				obj=new Object6_05();
			}
		}catch (InterruptedException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return obj;
	}

}
