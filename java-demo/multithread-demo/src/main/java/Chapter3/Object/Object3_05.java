package Chapter3.Object;

public class Object3_05 {
	//���÷���notifyһ��ֻ��֪ͨһ���̲߳����ѣ�notifyAll֪ͨ����
	
	public void Method1(Object lock){
		try{
			synchronized (lock) {
				System.out.println("��ʼ�ȴ����߳���"+Thread.currentThread().getName());
				lock.wait();
				System.out.println("�����ȴ����߳���"+Thread.currentThread().getName());
			}
		}catch (InterruptedException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
