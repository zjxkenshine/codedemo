package Chapter3.Test;

import Chapter3.Object.Object3_02_4;
import Chapter3.Thread.Thread3_02_4A;
import Chapter3.Thread.Thread3_02_4B;

public class Test3_02_4 {
	//wait��notifyʵ��size=5��ʵ��
	
	/**1.�ؼ���synchronized����κ�һ��Object������Ϊͬ�����󿴴�
	 * 
	 * 2.�����»��ѵ��̻߳���ͼ���»�ȡ�ٽ�����������ִ���ٽ�����wait����Ĵ���
	 *   �������notifyʱû�д���wait���̣߳���ô������ᱻ����
	 * 
	 * 3.notify�������Ի��ѵȴ������е�һ���̣߳���ʹ���߳��˳��ȴ���Ϊ������״̬��ֻ֪ͨһ��
	 * 
	 * 4.notifyAll:֪ͨ����wait���߳�
	 */
	
	public static void main(String[] args) {
		try{
			Object obj=new Object();
			Thread3_02_4A t1=new Thread3_02_4A(obj);
			t1.start();
			Thread.sleep(1000);
			Thread3_02_4B t2=new Thread3_02_4B(obj);
			t2.start();
			
		}catch(InterruptedException e){
			e.printStackTrace();
		}
	}

}