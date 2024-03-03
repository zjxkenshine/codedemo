package Chapter7.Test;

public class Test7_08 {
	//获取根线程组
	
	public static void main(String[] args) {
		System.out.println("线程："+Thread.currentThread().getName()+" 所在线程组名："+Thread.currentThread().getThreadGroup().getName());
		System.out.println("main线程所在线程组的父线程组名是："+Thread.currentThread().getThreadGroup().getParent().getName());
	//取System父线程组会报空异常
		System.out.println("main线程所在线程组的父线程组的父线程组名是："+Thread.currentThread().getThreadGroup().getParent().getParent().getName());
	}

}
