package Chapter7.Test;

import Chapter7.Thread.Thread7_17_1;

public class Test7_17_1 {
	//�߳����ڴ����쳣
	
	/**
	 * һ���̳߳����쳣���߳����������̻߳᲻��ֹͣ
	 * �߳���һ���̳߳����쳣����Ӱ�������̵߳�����
	 * @param args
	 */
	
	public static void main(String[] args) {
		ThreadGroup group=new ThreadGroup("�߳���");
		Thread7_17_1[] tlist=new Thread7_17_1[10];
		
		for(int i=0;i<tlist.length;i++){
			tlist[i]=new Thread7_17_1(group, "�߳�"+(i+1),"111");
			tlist[i].start();
		}
		
		Thread7_17_1 th=new Thread7_17_1(group, "�����߳�", "a");
		th.start();
		
	}

}
