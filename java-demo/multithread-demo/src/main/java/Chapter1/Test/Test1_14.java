package Chapter1.Test;

import Chapter1.Thread.Thread1_14;

public class Test1_14 {
	//getId()��������ȡ�̵߳�Ψһ��ʾ
	public static void main(String[] args) {
		Thread1_14 thread=new Thread1_14();
		thread.setName("�߳�A");
		thread.start();
		System.out.println(Thread.currentThread().getName()+","+Thread.currentThread().getId());
	}

}
