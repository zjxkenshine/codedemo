package Chapter7.Thread;

public class Thread7_12 extends Thread{
	//ʹ�߳̾���������
	
	private Object lock;
	private String showChar;
	private int showNumPosition;
	private int printCount=0;           //ͳ�ƴ�ӡ�˼�����ĸ
	volatile private static int addNumber=1;
	
	public Thread7_12(Object lock,String showChar,int showNumPosition) {
		// TODO Auto-generated constructor stub
		super();
		this.lock=lock;
		this.showChar=showChar;
		this.showNumPosition=showNumPosition;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		try{
			synchronized (lock) {
				while(true){
					if(addNumber%3==showNumPosition){
						System.out.println("ThreadName="+Thread.currentThread().getName()+" runCount="+addNumber+" showChar="+showChar);
						lock.notifyAll();
						addNumber++;
						printCount++;
						if(printCount==3){          //ÿ�������ӡ���κ��˳�,������ABC
							break;
						}
					}else{
						lock.wait();
					}
				}
			}
		}catch (InterruptedException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
