package Chapter1.Test;

import Chapter1.Thread.runnable1_4;

public class Test1_4 {
	//�̵߳���һ��ʵ�ַ�ʽ��ʵ��runnable�ӿ�
	//Thread��Ҳ��ͨ��ʵ�ָýӿ�
	
	public static void main(String[] args) {
		
		runnable1_4 run=new runnable1_4();
		Thread thread=new Thread(run);
		thread.start();
		System.out.println("main�߳̽�����");
	}

}
