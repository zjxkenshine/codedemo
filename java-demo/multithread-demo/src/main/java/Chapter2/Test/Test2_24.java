package Chapter2.Test;

import Chapter2.Thread.Thread2_24;

public class Test2_24 {
	//���̵߳�����
	
	/**
	 * �������ȴ������ܱ��ͷŵ������Ӷ��������������޷��������
	 * 
	 * �����Ǳ������ģ�������̵߳ļ���
	 * 
	 * ֻҪ����ȴ��Է����п����������
	 * @throws InterruptedException 
	 * 
	 */
	
	
	public static void main(String[] args) throws InterruptedException {
		
		Thread2_24 t=new Thread2_24();
		t.setFlag("a");
		Thread a=new Thread(t);
		a.start();
		Thread.sleep(100);
		t.setFlag("b");
		Thread b=new Thread(t);
		b.start();
	}

}
