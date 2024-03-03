package Chapter3.Test;

public class Test3_24 {
	//get()方法与null 0ol,
	
	/**1.变量值的共享可以使用public static变量的形式，所有线程都使用同一个public static变量
	 * 
	 * 2.如果想每一个线程都有自己的共享变量----JDK中提供了ThreadLocal类
	 * 
	 * 3.ThreadLocal主要解决的就是每个线程都绑定自己的值，可以将ThreadLocal类比作全局存放数据的盒子，盒子里可以存放
	 * 
	 * 4.ThreadLocal解决的是变量在不同线程中的隔离性，不同线程有不同的值，不同线程中值也可以放入ThreadLocal类进行保存
	 */
	
	public static ThreadLocal t1=new  ThreadLocal();
	
	public static void main(String[] args) {
		if(t1.get()==null){
			System.out.println(t1.get());
			System.out.println("此时ThreadLocal中没有值");
			t1.set("有值了");
		}
		System.out.println(t1.get());
		System.out.println(t1.get());
	}

}
