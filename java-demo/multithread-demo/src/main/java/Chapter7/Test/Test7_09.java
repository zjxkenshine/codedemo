package Chapter7.Test;

public class Test7_09 {
	//�߳�������߳���
	
	/**
	 * ��ʾ��ʽ���߳��������һ�����߳�
	 * @param args
	 */
	
	public static void main(String[] args) {
		System.out.println("�߳�������"+Thread.currentThread().getThreadGroup().getName());
		System.out.println("�߳����л���߳�������"+Thread.currentThread().getThreadGroup().activeCount());
		System.out.println("�߳����л���߳�������--���߳���ǰ��"+Thread.currentThread().getThreadGroup().activeGroupCount());
		
		ThreadGroup newgop=new ThreadGroup(Thread.currentThread().getThreadGroup(),"newGroup");
		
		System.out.println("�߳����л���߳�������--���߳����"+Thread.currentThread().getThreadGroup().activeGroupCount());
	    
	}

}
