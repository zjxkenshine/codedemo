package Chapter7.Test;

public class Test7_07 {
	//�߳�����Զ���������
	
	/*1.����activeGroupCount()�����ǻ�ȡ��ǰ�̶߳����е����߳��������
	 *  ����enumerate()�������ǽ��߳����е����߳��Ը��Ƶ���ʽ������ThreadGroup[]���������
	 *  
	 * 2.��ʵ����һ��ThreadGroup�߳�����Xʱ�����ָ�������߳��飬��x�߳����Զ��鵽��ǰ�߳��������߳����У�
	 *   Ҳ������ʽ����һ���߳����������һ�����߳���
	 * 
	 */
	
	public static void main(String[] args) {
		
		System.out.println("A���̣߳�"+Thread.currentThread().getName()+" �����߳������ƣ�"+Thread.currentThread().getThreadGroup()+" �߳��������߳����������"+Thread.currentThread().getThreadGroup().activeGroupCount());
		ThreadGroup group=new ThreadGroup("�µ���");          //�Զ����뵽main�߳�����
		System.out.println("B���̣߳�"+Thread.currentThread().getName()+" �����߳������ƣ�"+Thread.currentThread().getThreadGroup()+" �߳��������߳����������"+Thread.currentThread().getThreadGroup().activeGroupCount());
		
		ThreadGroup[] tgrup=new ThreadGroup[Thread.currentThread().getThreadGroup().activeGroupCount()];
		Thread.currentThread().getThreadGroup().enumerate(tgrup);
		for(int i=0;i<tgrup.length;i++){
			System.out.println("��һ���߳�������Ϊ��"+tgrup[i].getName());
		}
	}
	 

}
