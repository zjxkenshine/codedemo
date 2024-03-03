package Chapter2;

public class chap2 {
	/**第二章：对象及变量的并发访问
	 * 
	 * -----------synchronized同步方法----------------
	 * 2_01: 方法内的变量为线程安全
	 * 2_02: 实例变量非线程安全
	 * 2_03: 多个对象会产生多个锁
	 * 2_04: synchronized方法锁的是实例对象而非方法
	 * 2_05: 脏读（dirtyRead）
	 * 2_06: synchronized锁的重入
	 * 2_07: 代码出现异常时，其所持有的锁会自动释放
	 * 2_08: 同步不具有继承性
	 * 
	 * -----------synchronized(this)同步语句块----------------
	 * 2_09: synchronized方法的弊端--长时间排队
	 * 2_10: synchronized(this)同步代码块的使用
	 * 2_11: synchronized(this)解决同步方法的弊端
	 * 2_12: 同步代码块一半同步一半异步
	 * 2_13: synchronized(this)代码块间的同步性
	 * 2_14: 验证synchronized(this)代码块是锁定当前对象的
	 * 
	 * -----------synchronized(任意非this对象)同步语句块----------------
	 * 2_15: 将任意非this对象x作为【对象监视器】   synchronized(任意非this对象)
	 * 2_16: synchronized(任意非this对象x)解决脏读问题
	 * 2_17: synchronized(任意非this对象x)结论验证1：
	 *            多个线程同时执行synchronized(x){}同步代码块时呈同步效果
	 * 2_18: synchronized(任意非this对象x)结论验证2：
	 *           当其他线程执行x对象中的synchronized同步方法时呈同步效果
	 * 2_19: synchronized(任意非this对象x)结论验证3：
	 *           当其他线程执行x对象中的synchronized(this)同步代码块时呈同步效果
	 * 
	 * -----------synchronized一些其他知识点----------------     
	 * 2_20: 静态同步synchronized方法
	 * 2_21: synchronized(class)代码块
	 * 2_22: 【String常量池的特性】给synchronized(String)带来的例外,使用obj对象做监视器
	 * 2_23: 同步synchronized方法无限等待与解决    
	 * 2_24: 多线程的死锁
	 * 2_25: 内置类与静态内置类
	 * 2_26: 内置类与同步实验1
	 * 2_27: 内置类与同步实验2
	 * 2_28: 锁对象的改变
	 * 
	 * -----------volatile关键字---------------- 
	 * 2_29: volatile关键字与死循环
	 * 2_30: volatile解决同步死循环
	 * 2_31: volatile解决异步死循环（volatile与synchronized的比较）
	 * 2_32: volatile的非原子特性
	 *           
	 * -----------原子类与其他----------------           
	 * 2_33: 使用原子类对i++进行操作
	 * 2_34: 原子类也并非完全安全
	 * 2_35: synchronized代码块有volatile同步功能          
	 *           
	 *           
	 */
}
