package Chapter3.Object;

import java.util.Date;

public class Object3_29_1 extends InheritableThreadLocal{
	

	protected Object initialValue(){
		return new Date().getTime();
	}
	
	protected Object childValue(Object parentValue){
		return parentValue+" �����߳���ӵ�";
	}


}
