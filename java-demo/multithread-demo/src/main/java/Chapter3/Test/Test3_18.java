package Chapter3.Test;

import Chapter3.Thread.Thread3_18;

public class Test3_18 {
	//学习join前的铺垫
	
	/**很多时候如果子线程要进行大量的耗时处理，主线程将早与子线程结束
	 * 如果想要主线程在子线程之后结束，就要用join方法
	 * join()方法的作用是等待线程对象销毁
	 * 
	 * 本例是不使用join的方法
	 */
	public static void main(String[] args) {
		Thread3_18 t1=new Thread3_18();
		t1.start();
		//Thread.Sleep(?);
		System.out.println("我想当Thread3_18执行后再执行后面的代码");
		System.out.println("但是上面的sleep中的值不确定");
	}
	

}
