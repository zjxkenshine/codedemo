package Chapter4.Test;

import Chapter4.Object.Service4_10_3;

public class Test4_10_3 {
	//getWaitQueueLength(Condition condition)����
	
	/**getWaitQueueLength(Condition condition)�����Ƿ��صȴ����������صĸ�������condition���̹߳�����
	 * ����ִ���˴�condition��await������û���ͷŵ��̵߳ĸ���
	 * ����5���̣߳�ÿ���߳�ִ��ͬһ��condition��await����ô���ص���5
	 * 
	 * @param args
	 * @throws InterruptedException 
	 */
	
	public static void main(String[] args) throws InterruptedException {
		final Service4_10_3 ser=new Service4_10_3();
		Runnable run=new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				ser.WaitMethod();
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
		ser.SingalMethod();
	}

}
