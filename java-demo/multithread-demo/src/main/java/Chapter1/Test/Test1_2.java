package Chapter1.Test;

import Chapter1.Thread.Thread1_2;

public class Test1_2 {
	//�̵߳�����Բ���
	//Cpuִ���ĸ��߳̾��в�ȷ����
	public static void main(String[] args) {
		try{
			Thread1_2 thread=new Thread1_2();
			thread.setName("myThread");   //�����߳���
			thread.start();         //�����߳�main
			
			//�������̶߳�����threadһ��
			for(int i=0;i<10;i++){
				int time =(int)(Math.random()*1000);
				Thread.sleep(time);     //�߳�����
				System.out.println("����ִ���߳�"+Thread.currentThread().getName()); //��ȡ��ǰ�߳���
			}
		}catch(InterruptedException e){   //�ж��쳣
			e.printStackTrace();
		}
	}
}
