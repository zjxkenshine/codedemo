package Chapter7.Test;

public class Test7_08 {
	//��ȡ���߳���
	
	public static void main(String[] args) {
		System.out.println("�̣߳�"+Thread.currentThread().getName()+" �����߳�������"+Thread.currentThread().getThreadGroup().getName());
		System.out.println("main�߳������߳���ĸ��߳������ǣ�"+Thread.currentThread().getThreadGroup().getParent().getName());
	//ȡSystem���߳���ᱨ���쳣
		System.out.println("main�߳������߳���ĸ��߳���ĸ��߳������ǣ�"+Thread.currentThread().getThreadGroup().getParent().getParent().getName());
	}

}
