package Chapter2.Test;

import Chapter2.Thread.Thread2_31;

public class Test2_31 {
	//volatile解决异步死循环
	
	/**1.不使用volatile关键字在_server环境下出现死循环， _server环境下一直在私有堆栈中运行，（图：书本P122）
	 * 	   而setRunning改变的是公共堆栈的值，无法被线程取到，所以添加volatile关键字强制读取公共堆栈的值
	 * 
	 * 2.这种死循环主要由私有堆栈值与公共堆栈中的值不同步造成的
	 * 	 使用volatile关键字增加了实例变量在多个线程之间的可见性，但volatile关键字的致命缺点是【不支持原子性】
	 * 
	 * 3.synchronized关键字与volatile关键字的比较
	 *  a. 关键字volatile是线程同步的轻量级实现，所以volatile性能比synchronized好，
	 *     但volatile只能修饰变量，synchronized可以修饰方法，代码块。JDK版本更新，synchronized的性能不断提升。
	 * 
	 *  b. 多线程访问volatile不会阻塞，而访问synchronized会阻塞。
	 *  
	 *  c. volatile能保证数据的可见性，但不能保证原子性
	 *     synchronized可以保证原子性，也可以间接保证可见性，因为他会将私有内存和公共内存中的数据做同步
	 *     
	 *  d. 关键字volatile解决的是变量在多个线程之间的可见性，
	 *     而synchronized关键字解决的是多个线程之间访问资源的同步性
	 * 
	 */
	
	public static void main(String[] args) {
		try{
			Thread2_31 thread=new Thread2_31();
			thread.start();
			Thread.sleep(1000);             //thread线程停止1秒
			thread.setRunning(false);
			
			System.out.println("已经赋值为false");
			
		}catch(InterruptedException e){
			e.printStackTrace();
		}
	}

}
