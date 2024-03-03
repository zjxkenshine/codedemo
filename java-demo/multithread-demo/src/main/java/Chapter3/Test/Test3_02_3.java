package Chapter3.Test;

import Chapter3.Thread.Thread3_02_3A;
import Chapter3.Thread.Thread3_02_3B;

public class Test3_02_3 {
	//notify使等待的线程继续运行wait后的代码
	
	public static void main(String[] args) {
	   try{
		   Object lock=new Object();
		   Thread3_02_3A t1=new Thread3_02_3A(lock);
		   t1.start();
		   Thread.sleep(3000);
		   Thread3_02_3B t2=new Thread3_02_3B(lock);
		   t2.start();
		   
	   }catch (InterruptedException e) {
		// TODO: handle exception
		   e.printStackTrace();
	}
	}

}
