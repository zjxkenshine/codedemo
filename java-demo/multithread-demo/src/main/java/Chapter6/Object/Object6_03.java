package Chapter6.Object;

public class Object6_03 {
	//延迟加载/懒汉模式解析
	
	public static Object6_03 obj;
	
	public Object6_03() {
		// TODO Auto-generated constructor stub
	}
	
	public static Object6_03 getInstance(){
		//延迟加载
		if(obj!=null){
		}else{
			obj=new Object6_03();
		}
		return obj;
	}

}
