package Chapter4.Test;

import Chapter4.Object.Service4_10_2;

public class Test4_10_2 {
	//getQueueLength()����
	
	/**getQueueLength()�����������Ƿ������ڵȴ��������̹߳������� �����5���̣߳�
	 * һ���߳�����ִ��await��������ô����getQueueLength�����ķ���ֵ��4��
	 * ��ô˵����4���߳���ͬʱ�ȴ�lock�ͷ�
	 * @throws InterruptedException 
	 */
	
	public static void main(String[] args) throws InterruptedException {
		final Service4_10_2 ser=new Service4_10_2();
		Runnable runn=new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				ser.TestMethod();
				
			}
		};
		Thread[] tl=new Thread[10];
		for(int i=0;i<10;i++){
			tl[i]=new Thread(runn);
		}
		for(int i=0;i<10;i++){
			tl[i].start();
		}
		Thread.sleep(2000);
		System.out.println("��"+ser.lock.getQueueLength()+"���߳��ڵȴ���");
	}

}
