package Chapter4.Test;

import Chapter4.Object.Service4_12_2;

public class Test4_12_2 {
	//isHeldByCurrentThread()����
	
	/**boolean lock.isHeldByCurrentThread()�����������ǲ�ѯ��ǰ�߳��Ƿ���д���
	 */
	public static void main(String[] args) {
		final Service4_12_2 ser=new Service4_12_2(true);
		Runnable runn=new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				ser.serviceMethod();
			}
		};
		Thread t1=new Thread(runn);
		t1.start();
	}
	
	

}
