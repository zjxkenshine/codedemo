package Chapter6.Object;

public class Object6_11 {
	//使用static代码实现单例模式
	
	private static Object6_11 ins=null;
	
	public Object6_11() {
		// TODO Auto-generated constructor stub
	}
	
	//static代码块
	static{
		ins=new Object6_11();
	}
	
	public static Object6_11 get(){
		return ins;
	}

}
