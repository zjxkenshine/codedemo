package Chapter3.Object;

public class Substract3_08 {
	
	private String lock;
	public Substract3_08(String lock){
		super();
		this.lock=lock;
	}
	/*
	//���󷽷�����������쳣

   public void Subtract(){
		try{
			synchronized (lock) {
			if(Object3_08.list.size()==0){
				System.out.println("�߳̿�ʼ�ȴ���"+Thread.currentThread().getName());
				lock.wait();
				System.out.println("�߳̽����ȴ���"+Thread.currentThread().getName());
			}
			Object3_08.list.remove(0);
			System.out.println("list size="+Object3_08.list.size());
			}
		}catch (InterruptedException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	*/
	
	//�Եķ���
	 public void Subtract(){
			try{
				synchronized (lock) {
				while(Object3_08.list.size()==0){
					System.out.println("�߳̿�ʼ�ȴ���"+Thread.currentThread().getName());
					lock.wait();
					System.out.println("�߳̽����ȴ���"+Thread.currentThread().getName());
				}
				Object3_08.list.remove(0);
				System.out.println("list size="+Object3_08.list.size());
				}
			}catch (InterruptedException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}

}
