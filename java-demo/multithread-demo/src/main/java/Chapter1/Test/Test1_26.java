package Chapter1.Test;

import Chapter1.Thread.Thread1_26_1;

public class Test1_26 {
	//�߳����ȼ��ļ̳���
	/**ʹ��setPriority()���������߳����ȼ�1-10
	 * 
	 * jdk�е�Ԥ���峣����
	 * MIN_PRIORITY=1
	 * NORM_PRIORITY=5
	 * MAX_PRIORITY=10
	 * 
	 * �̳��ԣ�
	 * A�߳�����B�̣߳���B�߳����ȼ���A��ͬ
	 * 
	 */
	public static void main(String[] args) {
		System.out.println("main �� priority="+Thread.currentThread().getPriority());
		//Thread.currentThread().setPriority(6);    //ע����һ��
		System.out.println("main �� priority="+Thread.currentThread().getPriority());
		Thread1_26_1 thread=new Thread1_26_1();
		thread.start();
	}

}
