package Chapter4.Test;

import Chapter4.Object.Service4_11_2;

public class Test4_11_2 {
	//hasWaiters(Condition condition)����
	
	/**
	 * boolean hasWaiters(Condition condition)���������ǲ�ѯ�Ƿ����߳��ڵȴ����������ص�condition����
	 * @throws InterruptedException 
	 * 
	 */
	
	public static void main(String[] args) throws InterruptedException {
		final Service4_11_2 ser=new Service4_11_2();
		Runnable run=new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				ser.waitMethod();
			}
		};
		Thread[] tlist=new Thread[10];
		
		for(int i=0;i<10;i++){
			tlist[i]=new Thread(run);
		}
		
		for(int i=0;i<10;i++){
			tlist[i].start();
		}
		Thread.sleep(2000);
		ser.notifyMethod();
	}

}
