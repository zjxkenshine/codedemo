package Chapter7.Test;

public class Test7_09 {
	//线程组里加线程组
	
	/**
	 * 显示方式在线程组中添加一个子线程
	 * @param args
	 */
	
	public static void main(String[] args) {
		System.out.println("线程组名称"+Thread.currentThread().getThreadGroup().getName());
		System.out.println("线程组中活动的线程数量："+Thread.currentThread().getThreadGroup().activeCount());
		System.out.println("线程组中活动的线程组数量--加线程组前："+Thread.currentThread().getThreadGroup().activeGroupCount());
		
		ThreadGroup newgop=new ThreadGroup(Thread.currentThread().getThreadGroup(),"newGroup");
		
		System.out.println("线程组中活动的线程组数量--加线程组后："+Thread.currentThread().getThreadGroup().activeGroupCount());
	    
	}

}
