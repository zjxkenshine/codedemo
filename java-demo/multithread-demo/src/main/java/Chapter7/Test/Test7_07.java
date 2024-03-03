package Chapter7.Test;

public class Test7_07 {
	//线程组的自动归属特性
	
	/*1.方法activeGroupCount()作用是获取当前线程对象中的子线程组的数量
	 *  方法enumerate()的作用是将线程组中的子线程以复制的形式拷贝到ThreadGroup[]数组对象中
	 *  
	 * 2.在实例化一个ThreadGroup线程数组X时如果不指定所属线程组，则x线程组自动归到当前线程所属的线程组中，
	 *   也就是隐式地在一个线程组中添加了一个子线程组
	 * 
	 */
	
	public static void main(String[] args) {
		
		System.out.println("A处线程："+Thread.currentThread().getName()+" 所属线程组名称："+Thread.currentThread().getThreadGroup()+" 线程组内有线程组的数量："+Thread.currentThread().getThreadGroup().activeGroupCount());
		ThreadGroup group=new ThreadGroup("新的组");          //自动加入到main线程组中
		System.out.println("B处线程："+Thread.currentThread().getName()+" 所属线程组名称："+Thread.currentThread().getThreadGroup()+" 线程组内有线程组的数量："+Thread.currentThread().getThreadGroup().activeGroupCount());
		
		ThreadGroup[] tgrup=new ThreadGroup[Thread.currentThread().getThreadGroup().activeGroupCount()];
		Thread.currentThread().getThreadGroup().enumerate(tgrup);
		for(int i=0;i<tgrup.length;i++){
			System.out.println("第一个线程组名称为："+tgrup[i].getName());
		}
	}
	 

}
