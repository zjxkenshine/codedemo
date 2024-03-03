package Chapter3.Object;

import java.util.Date;

public class Object3_27_1 extends ThreadLocal{
	//验证多个线程的初始值
	
	protected Object initialValue(){
		return new Date().getTime();
	}

}
