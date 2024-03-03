package Chapter6.Object;

import java.io.ObjectStreamException;
import java.io.Serializable;

public class Object6_10 implements Serializable{
	//序列化与反序列化的单例模式实现
	
	private static final long serialVersionUID=4448L;
	
	//内部类方法
	private static class Object6_10Handler{
		private static final Object6_10 obj=new Object6_10();
	}
	
	public Object6_10() {
		// TODO Auto-generated constructor stub
	}
	
	public static Object6_10 getInstance(){
		System.out.println("getInstance"+Object6_10Handler.obj.hashCode());
		return Object6_10Handler.obj;
	}
	
	//以下这几条语句加上与不加
	
	protected Object readResolve() throws ObjectStreamException{
		System.out.println("调用了readResolve()方法");
		System.out.println("readResolve"+Object6_10Handler.obj.hashCode());
		return Object6_10Handler.obj;
	}

}
