package Chapter6.Test;

import Chapter6.Thread.Thread6_05;

public class Test6_05 {
	//�ӳټ���/����ģʽ��ȱ��Ľ������1������synchronize�ؼ���
	
	/**
	 * ����߳̿���ͬʱ����getInstance������ֻҪ��getInstance��������synchronized�ؼ��ּ���
	 * 
	 * ���ַ�����Ч�ʷǳ����£�ͬ�����У���һ���߳���Ҫȡ�ö��󣬱������һ���߳��ͷ���֮��ſ���ִ��
	 */
	
	public static void main(String[] args) {
		Thread6_05 t1=new Thread6_05();
		Thread6_05 t2=new Thread6_05();
		Thread6_05 t3=new Thread6_05();
		t1.start();
		t2.start();
		t3.start();
		
	}

}
