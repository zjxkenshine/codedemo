package Chapter3.Test;

import Chapter3.Thread.Thread3_23A;
import Chapter3.Thread.Thread3_23B;

public class Test3_23 {
	//方法join()后面的代码提前运行：出现意外
	
	/**
	 * 有时join后的代码提前于tb执行
	 * 
	 * 具体解释：(书本P189-P191)
	 * 
	 * join再次得到锁时已经过了两秒，自动释放导致失效
	 * join总是最新抢到锁
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		try{
			Thread3_23B tb=new Thread3_23B();
			Thread3_23A ta=new Thread3_23A(tb);
			ta.start();
			tb.start();
			tb.join(2000);               //将时间变长或直接用join()方法而不用join(long)可解决
			System.out.println("main 方法结束了");
		}catch(InterruptedException e){
			e.printStackTrace();
		}
	}

}
