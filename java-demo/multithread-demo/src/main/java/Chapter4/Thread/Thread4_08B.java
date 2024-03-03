package Chapter4.Thread;

import Chapter4.Object.Service4_08;

public class Thread4_08B extends Thread{
   private Service4_08 ser=new Service4_08();
	
	public Thread4_08B(Service4_08 ser) {
		// TODO Auto-generated constructor stub
		this.ser=ser;
	}
	
    @Override
    public void run() {
    	// TODO Auto-generated method stub
    	super.run();
    	for(int i=0;i<Integer.MAX_VALUE;i++){
    		ser.get();
    	}
    }

}
