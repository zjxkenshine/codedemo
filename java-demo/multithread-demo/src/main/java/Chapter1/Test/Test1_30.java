package Chapter1.Test;

import Chapter1.Thread.Thread1_30;

public class Test1_30 {
	//�ػ��߳����û��߳�
	/**1.�߳��в����ڷ��ػ��̣߳��û��̣߳�ʱ���ػ��߳��Զ�����
	 * 2.ֻҪ��ǰJVMʵ���д����κ�һ�����ػ��߳�û�н������ػ��߳̾��ڹ���
	 * 	ֻ�е����һ�����ػ��߳̽���ʱ���ػ��̲߳���JVMһͬ����
	 * 3.�ػ��߳�����͵�Ӧ�þ���GC
	 * 4.������thread.setDaemon(true)
	 */
	
	public static void main(String[] args) {
		try{
			Thread1_30 thread=new Thread1_30();
			thread.setDaemon(true);              //����Ϊ�ػ��߳�
			thread.start();
			Thread.sleep(5000);
			System.out.println("main�߳̽�����thread�߳�Ҳ���ٴ�ӡ��ֹͣ��");
		}catch(InterruptedException e){
			e.printStackTrace();
		}
	}

}
