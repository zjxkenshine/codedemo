package Chapter7.Test;


public class Test7_06 {
	//�̶߳�������߳��飺�༶����
	
	/**1.�༶�������Ǹ����������Ӷ����Ӷ������ٴ����Ӷ���Ҳ���ǳ����������
	 * 
	 * 2.���ַ����ڿ����в��������߳������ڸ��ӷ����������̶߳���Ĺ���
	 *   ����JDK�ṩ��֧�ֶ༶�������߳����ṹ
	 * 
	 */
	
	public static void main(String[] args) {
	    //��main�߳��������һ���߳���tg1,��tg1������̶߳���Z
		//����activeGroupCount()��activeCount()deֵ���ǹ̶���
		//�ǻ����е�һ������
		
		ThreadGroup mainGrop=Thread.currentThread().getThreadGroup();
		ThreadGroup tg=new ThreadGroup(mainGrop,"666");
		Runnable runn=new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				
				try {
					System.out.println("runMethod");
					Thread.sleep(10000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		};
		Thread newtd=new Thread(tg,runn);
		newtd.setName("Z");
		newtd.start();            //���������Ż�鵽TG�߳�����
		
		ThreadGroup[] listgroup=new ThreadGroup[Thread.currentThread().getThreadGroup().activeCount()];
		
		Thread.currentThread().getThreadGroup().enumerate(listgroup);
		System.out.println("main�߳����ж��ٸ����߳���"+listgroup.length+"   ����Ϊ��"+listgroup[0].getName());
		
		Thread[] listTd=new Thread[listgroup[0].activeCount()];
		listgroup[0].enumerate(listTd);
		System.out.println(listTd[0].getName());
		
	}

}
