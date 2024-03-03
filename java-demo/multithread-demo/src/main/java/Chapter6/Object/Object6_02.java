package Chapter6.Object;

public class Object6_02 {
	//立即加载/饿汉模式
	
	private static Object6_02 obj=new Object6_02();     //提前加载
	
	private Object6_02() {
		// TODO Auto-generated constructor stub
	}
	
	public static Object6_02 getInstance(){
		//此代码版本是立即加载
		//缺点是不能有其他实例变量，因为getInstance方法没有同步，可能会出现非线程安全
		
		return obj;
		
	}
	
	

}
