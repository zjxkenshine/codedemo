package Chapter1.Thread;

public class Thread1_5 extends Thread{
	//���ݲ�����
	private int count=6;
	public Thread1_5(String name){
		super();
		this.setName(name);
	}
	
	@SuppressWarnings("static-access")
	public void run(){
		super.run();
		while(count>0){
			count--;
			System.out.println("���߳�"+this.currentThread().getName()+"���㣬count="+count);
		}
	}
}
