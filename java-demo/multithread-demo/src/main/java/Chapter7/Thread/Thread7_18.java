package Chapter7.Thread;

public class Thread7_18 extends Thread{
	//�߳��쳣����Ĵ���
	
	
	private String num="a";
	public Thread7_18() {
		// TODO Auto-generated constructor stub
	}
	
	public Thread7_18(ThreadGroup7_18 tg,String name) {
		// TODO Auto-generated constructor stub
		super(tg,name);
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		int numInt=Integer.parseInt(num);
		System.out.println("���߳��д�ӡ:"+(numInt+1));
	}

}
