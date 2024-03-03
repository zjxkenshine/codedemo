package Chapter1.Test;

import Chapter1.Thread.Thread1_27_1;
import Chapter1.Thread.Thread1_27_2;

public class Test1_27_1 {
	//线程优先级的规则性
	/**1.高优先级总是先大部分执行完，但不代表高优先级全部先执行完
	 * 2.优先级差距很大时，谁先执行完与代码调用顺序无关
	 * 3.cpu会尽量将执行资源让给优先级比较高的线程
	 */
	public static void main(String[] args) {
		for(int i=0;i<5;i++){
			Thread1_27_1 thread1=new Thread1_27_1();
			thread1.setPriority(10);
			thread1.start();
			Thread1_27_2 thread2=new Thread1_27_2();
			thread2.setPriority(1);
			thread2.start();
		}
	}
}
