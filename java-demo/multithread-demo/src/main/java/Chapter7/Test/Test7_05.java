package Chapter7.Test;

import Chapter7.Thread.Thread7_05A;
import Chapter7.Thread.Thread7_05B;

public class Test7_05 {
	//�̶߳�������߳��飺һ������
	
	/**1.���԰��̹߳�����ĳһ���߳����У��߳����п������̶߳���Ҳ�������߳���,���л��������߳�
	 * 
	 * 2.�߳���������ǣ��������������̻߳��߳���,��Ч�ض��̻߳��߳�����������֯
	 * 
	 * 3.1����������ν��1���������Ǹ����������Ӷ��󣬵��ǲ��������������
	 *   ��������������ڿ����С����紴��һЩ�߳�ʱ��Ϊ����Ч����Щ�߳̽�����֯����
	 *   ͨ��������Ǵ���һ���߳��飬Ȼ���ٽ������̹߳����������С�
	 *   ����������Զ���ɢ���̶߳��������Ч����֯��滮��
	 * 
	 */
	
	public static void main(String[] args) {
		Thread7_05A t1=new Thread7_05A();
		Thread7_05B t2=new Thread7_05B();
		ThreadGroup tg=new ThreadGroup("666��");
		
		Thread t11=new Thread(tg,t1);
		Thread t22=new Thread(tg,t2);
		
		t11.start();
		t22.start();
		
		System.out.println("��߳���Ϊ��"+tg.activeCount());
		System.out.println("�߳��������Ϊ��"+tg.getName());
	}

}
