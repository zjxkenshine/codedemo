package Chapter4.Test;

import Chapter4.Object.Service4_09;

public class Test4_09_2 {
	//�ǹ�ƽ��
	
	/**
	 * ��ȫ����start˳���ӡ
	 * @param args
	 */
public static void main(String[] args) {
		
		final Service4_09 ser=new Service4_09(false);             //�ǹ�ƽ��
		
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
