package Chapter3.Object;

public class P3_10 {
	//��������
	
	private String lock;
	public P3_10(String lock){
		super();
		this.lock=lock;
	}
	
	public void setValue(){
		try{
			synchronized (lock) {
			    while(!VObject3_10.value.equals("")){
			    	System.out.println(" ������"+Thread.currentThread().getName()+"��ʼ�ȴ�");
			    	lock.wait();
			    }
			    System.out.println("������"+Thread.currentThread().getName()+"��ʼִ��");
			    String value=System.currentTimeMillis()+"_"+System.nanoTime();
			    System.out.println("set ��ֵ��"+value);
			    VObject3_10.value=value;
			    // lock.notify(); 
			    
			   lock.notifyAll();
			}
		}catch (InterruptedException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
