package Chapter2.Thread;

import Chapter2.Object.Object2_22_2;
import Chapter2.Object.Service2_22_2;

public class Thread2_22_2B extends Thread{
	//��String�����ص����ԡ���synchronized(String)����������
	
private Service2_22_2 ser;
	
    public Thread2_22_2B(Service2_22_2 ser) {
		// TODO Auto-generated constructor stub
    	super();
    	this.ser=ser;
	}
    
    public void run(){
    	super.run();
    	ser.print(new Object2_22_2());
    }

}
