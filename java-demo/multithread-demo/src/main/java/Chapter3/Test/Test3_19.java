package Chapter3.Test;

import Chapter3.Thread.Thread3_19;

public class Test3_19 {
	//使用join()方法
	
	/** 1.方法join的作用是对所属的线程对象x正常执行run()方法中的任务，而使当前线程z无限阻塞
	 *    等待线程x销毁后
	 * 
	 * 2.join具有使线程排队的作用，与synchronized不同：
	 * 		join方法在内部使用wait()方法进行等待，
	 *      而synchronize关键字使用的是"对象监视器"原理进行同步
	 * 
	 */
	
	public static void main(String[] args) {
		try{
			Thread3_19 t1=new Thread3_19();
			t1.start();
			t1.join();
			System.out.println("我想当Thread3_18执行后再执行后面的代码");
			System.out.println("但是上面的sleep中的值不确定");
			
		}catch(InterruptedException e){
			e.printStackTrace();
		}
		
		
	}

}
