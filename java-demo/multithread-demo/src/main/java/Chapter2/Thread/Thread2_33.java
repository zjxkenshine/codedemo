package Chapter2.Thread;

import java.util.concurrent.atomic.AtomicInteger;

public class Thread2_33 extends Thread{
	//ʹ��ԭ�����i++���в���
	
	private AtomicInteger count=new AtomicInteger(0);
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		for(int i=0;i<10000;i++){
			System.out.println(count.incrementAndGet());      //count++����
		}
	}

}
