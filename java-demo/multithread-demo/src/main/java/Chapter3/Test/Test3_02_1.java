package Chapter3.Test;

public class Test3_02_1 {
	//等待/通知机制的实现（wait/notify方法）
	
	/**1.wait():
	 * 	--使当前执行代码的线程进行等待
	 * 	--wait是Object类的方法，将当前执行的线程放入"预执行队列"，并在wait()所在的代码处停止运行，直到接到通知或中断为止
	 * 	--*调用wait之前线程必须获得该对象的对象级别锁，只能在同步方法或同步块中调用wait方法
	 *  --如果调用wait时没有持有适当的锁，会抛出IlleaglMonistorStateExcption错误
	 * 
	 * 2.notify()
	 * 	--也要在同步方法中调用，否则报错IlleaglMonistorStateExcption，同wait
	 * 	--该方法用来通知那些可能等待【该对象的对象锁】的其他线程,如果有多个线程，
	 *    则随机挑选一个呈wait状态的线程，并使他【等待】获取该对象的锁
	 *  --在执行完notify()方法后，当前线程并不会马上释放锁，被选中的wait线程也不会立刻获得该对象锁
	 *    要等到执行notify()方法的线程执行完代码，退出synchronize同步后才可以
	 *  --第一个获取该对象的wait执行完后，如果该对象没有再次执行notify方法，则即使该对象已经空闲，
     *    其他wait等待的线程由于未收到通知，还会继续阻塞在wait状态，直到该对象发出一个notify或notifyAll
     *    
     *  3.wait使线程停止运行，而notify使线程继续运行
	 * 
	 */
	
	//测试没有对象监视器时的异常
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try{
			String newString=new String("");
			newString.wait();
		}catch(InterruptedException e){
			e.printStackTrace();
		}

	}

}
