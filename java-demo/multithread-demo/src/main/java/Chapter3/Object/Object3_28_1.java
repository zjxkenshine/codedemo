package Chapter3.Object;

import java.util.Date;

public class Object3_28_1 extends InheritableThreadLocal<Object>{
	//InheritableThreadLocalֵ�̳�
	
	protected Object initialValue(){
		return new Date().getTime();
	}
}
