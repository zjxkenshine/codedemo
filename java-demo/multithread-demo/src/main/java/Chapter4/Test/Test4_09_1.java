package Chapter4.Test;

import Chapter4.Object.Service4_09;

public class Test4_09_1 {
	//��ƽ��
	
	/**1.����Ϊ��ƽ����ǹ�ƽ������ƽ����ʾ�̻߳�ȡ����˳�����̼߳�����start����˳����з��䣬�ȵ��ȵã�FIFO
	 *    �ǹ�ƽ�����ǻ�ȡ������ռ���ƣ����������������Ĳ�һ���ȵõ���
	 *    
	 * 2.���н�����в��ֻ����������˳���ӡ
	 * 
	 * @param args
	 */
	
	public static void main(String[] args) {
		
		final Service4_09 ser=new Service4_09(true);             //��ƽ��
		
		Runnable runn=new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				System.out.println("********�߳�"+Thread.currentThread().getName()+"�����ˣ������ˣ�");
				ser.Method();
				
			}
			
		};
		Thread[] th=new Thread[10];
		
		for(int i=0;i<10;i++){
			th[i]=new Thread(runn);
		}
		
        for(int i=0;i<10;i++){
        	th[i].start();
		}
		
	}

}
