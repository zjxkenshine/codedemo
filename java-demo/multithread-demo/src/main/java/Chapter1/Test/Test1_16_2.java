package Chapter1.Test;

public class Test1_16_2 {
	//this.interrupted():�жϵ�ǰ�߳��Ƿ��жϣ�ִ�к�����жϱ��
	//ֹͣmain�̣߳���ǰ�̵߳������
	public static void main(String[] args) {
		Thread.currentThread().interrupt();    //main�߳�ֹͣ���
		System.out.println(Thread.currentThread().getName()+"�Ƿ��="+Thread.currentThread().isAlive());    //����ֹͣ����߳���Ȼ���
		System.out.println(Thread.currentThread().getName()+"�Ƿ�ֹͣ��="+Thread.interrupted());    //��main�̵߳���
		System.out.println(Thread.currentThread().getName()+"�Ƿ�ֹͣ��="+Thread.interrupted());    
		//��һ�������ǣ����Եڶ�����false
	}

}
