package Chapter3.Object;

import java.util.Date;

public class Object3_27_1 extends ThreadLocal{
	//��֤����̵߳ĳ�ʼֵ
	
	protected Object initialValue(){
		return new Date().getTime();
	}

}
