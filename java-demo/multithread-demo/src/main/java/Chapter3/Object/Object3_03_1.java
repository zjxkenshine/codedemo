package Chapter3.Object;

public class Object3_03_1 {
	//����wait()���ͷ�
	
	public void method1(Object lock){
		try{
			synchronized (lock) {
				System.out.println("��ʼ�ȴ�");
				lock.wait();
			//	Thread.sleep(1000);              //��Ϊsleep��ͬ��
				System.out.println("�����ȴ�");
			}
		}catch (InterruptedException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
