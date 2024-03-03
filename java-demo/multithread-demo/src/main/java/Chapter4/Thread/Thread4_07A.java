package Chapter4.Thread;

import Chapter4.Object.Service4_07;

public class Thread4_07A extends Thread{
	//实现生产者/消费者模式：一对一打印
	private Service4_07 ser=new Service4_07();
	
	public Thread4_07A(Service4_07 ser) {
		// TODO Auto-generated constructor stub
		this.ser=ser;
	}
	
    @Override
    public void run() {
    	// TODO Auto-generated method stub
    	super.run();
    	for(int i=0;i<Integer.MAX_VALUE;i++){
    		ser.set();
    	}
    }
}
