package Chapter4.Test;

import Chapter4.Object.Service4_10_1;

public class Test4_10_1 {
     //getHoldCount()方法
	
    /**getHoldCount()方法，查询当前线程保持此锁定的次数，也就是当前调用lock的次数
     */
	
	public static void main(String[] args) {
		Service4_10_1 ser=new Service4_10_1();
		ser.Method1();
	}
	

}
