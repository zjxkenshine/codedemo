package Chapter3.Object;

public class C3_10 {
	//��������
	
	private String lock;
	public C3_10(String lock){
		super();
		this.lock=lock;
	}
	
	public void getValue(){
		try{
			synchronized (lock) {
			    while(VObject3_10.value.equals("")){
			    	System.out.println(" ������"+Thread.currentThread().getName()+"��ʼ�ȴ�");
			    	lock.wait();
			    }
			    System.out.println("������"+Thread.currentThread().getName()+"��ʼִ��");
			    System.out.println("get ��ֵ��"+VObject3_10.value);
			    VObject3_10.value="";
			    //lock.notify(); 
			    
			    lock.notifyAll();
			}
		}catch (InterruptedException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
