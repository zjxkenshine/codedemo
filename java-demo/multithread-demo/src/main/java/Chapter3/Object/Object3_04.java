package Chapter3.Object;

public class Object3_04 {
	//interrupt��������wait����
	
	public void Method(Object lock){
		try{
			synchronized (lock) {
				System.out.println("begin");
				lock.wait();
				System.out.println("end");
			}
		}catch (InterruptedException e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println("�����쳣�ˣ���Ϊ�ȴ�״̬���̱߳�ֹͣ��");
		}
	}

}
