package Chapter3.Test;

import Chapter3.Object.Object3_26;

public class Test3_26 {
	//解决get返回初始值为null的问题
	
	
	public static Object3_26 t=new Object3_26();
	
	public static void main(String[] args) {
		if(t.get()==null){
			System.out.println("未放过值");
			t.set("我的值");
		}
		System.out.println(t.get());
		System.out.println(t.get());
	}

}
