package Chapter3.Object;

public class Object3_03_2 {
	//notify()�����ͷ�
	
	public void Method1(Object lock){
		try{
			synchronized (lock) {
			System.out.println("��ʼ�ȴ����߳��ǣ�"+Thread.currentThread().getName());
			lock.wait();
			System.out.println("�����ȴ����߳��ǣ�"+Thread.currentThread().getName());
			}
		}catch (InterruptedException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public void Method2(Object lock){
		try{
			synchronized (lock) {
			System.out.println("��ʼ֪ͨ���߳��ǣ�"+Thread.currentThread().getName());
			lock.notify();
			Thread.sleep(3000);
			System.out.println("����֪ͨ���߳��ǣ�"+Thread.currentThread().getName());
			}
		}catch (InterruptedException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
