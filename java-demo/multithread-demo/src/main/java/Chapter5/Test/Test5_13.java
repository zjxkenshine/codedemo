package Chapter5.Test;

public class Test5_13 {
	//方法scheduleAtFixedRate和schedule的区别
	
	/**1.方法scheduleAtFixedRate和schedule都会按顺序执行，不会出现非线程安全
	 * 
	 * 2.方法scheduleAtFixedRate和schedule的区别只体现在不延时的情况：
	 *   schedule:若没延时，下一个任务的执行时间参考的是上一次任务“开始”的时间来计算
	 *   scheduleAtFixedRate：若没延时，下一个任务的执行时间参考的是上一次任务“结束”的时间来计算(就是上一次任务“结束”的时间)
	 * 
	 * 3.延时的情况下没有区别：若被延时，下一个任务的执行时间都参考的是上一次任务“结束”的时间来计算(就是上一次任务“结束”的时间)
	 * 
	 * 4.schedule不具有任务追赶性,scheduleAtFixedRate具有任务追赶性
	 */

}
