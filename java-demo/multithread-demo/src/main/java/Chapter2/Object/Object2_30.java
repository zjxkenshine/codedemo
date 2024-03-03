package Chapter2.Object;

public class Object2_30 implements Runnable{
	//2_30: volatile���ͬ����ѭ��
	
	
	//private boolean isPrint=true;               //������-server������64λ��JVM�ϻ���ѭ��
	
	volatile private boolean isPrint=true;       //ʹ��volatile�ؼ���
	
	public boolean isPrint(){
		return isPrint;
	}
	
	public void setPrint(boolean a){
		this.isPrint=a;
	}
	
	public void MethodA(){
		try{
			while(isPrint){
				System.out.println("run MethodA threadName="+Thread.currentThread().getName());
				Thread.sleep(1000);
			}
		}catch(InterruptedException e){
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		MethodA();
	}
	
	

}
