package Chapter7.Test;

import Chapter7.Thread.Thread7_16;

public class Test7_16_1 {
	//线程中出现异常的处理
	
	/*
	 * 运行结果：会出现java.lang.NullPointerException异常
	 */
	
	public static void main(String[] args) {
		Thread7_16 t1=new Thread7_16();
		t1.start();
	}

}
