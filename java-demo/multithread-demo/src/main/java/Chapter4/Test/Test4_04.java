package Chapter4.Test;

import Chapter4.Object.Service4_04;
import Chapter4.Thread.Thread4_04;

public class Test4_04 {
	//��ȷʹ��Conditionʵ�ֵȴ�/֪ͨ
	
	/**Object���е�wait()�����൱��Condition���е�await()����
	 * Object���е�wait(long timeout)�����൱��Condition���е�await(long time,TimeUnit unit)����
	 * Object���е�notify()�����൱��Condition���е�signal()����
	 * Object���е�notifyAll()�����൱��Condition���е�signalAll()����
	 * 
	 */
	
	public static void main(String[] args) throws InterruptedException {
		Service4_04 ser=new Service4_04();
		Thread4_04 th=new Thread4_04(ser);
		th.start();
		Thread.sleep(3000);
		ser.signal();
	}

}
