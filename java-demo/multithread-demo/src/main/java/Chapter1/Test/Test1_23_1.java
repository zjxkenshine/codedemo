package Chapter1.Test;

import Chapter1.Thread.SychornizedObject1_23_1;

public class Test1_23_1 {
	//suspend()��resume()ȱ�����ӣ���ռ����ͬ������
	public static void main(String[] args) {
		try{
			final SychornizedObject1_23_1 object =new SychornizedObject1_23_1();
			Thread thread1=new Thread(){
				public void run(){
					object.printString();
				}
			};
			thread1.setName("a");
			thread1.start();
			Thread.sleep(1000);
			Thread thread2=new Thread(){
				public void run(){
					System.out.println("thread2�����ˣ������벻��printString()����");
					System.out.println("��ΪprintString()������a�߳�����������Զ��ͣ�ˣ�");
					object.printString();               //ִ�в��˸÷���
				}
			};
			thread2.start();
		}catch(InterruptedException e){
			e.printStackTrace();
		}
	}
}
