package Chapter3.Object;

public class Object3_26 extends ThreadLocal{
	//解决get返回初始值为null的问题
	
	//继承至ThreadLocalinitialValue()方法
	protected Object initialValue(){
		return "这是默认值，不再是null了";
	}

}
