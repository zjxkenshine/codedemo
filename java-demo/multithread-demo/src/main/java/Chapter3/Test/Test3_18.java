package Chapter3.Test;

import Chapter3.Thread.Thread3_18;

public class Test3_18 {
	//ѧϰjoinǰ���̵�
	
	/**�ܶ�ʱ��������߳�Ҫ���д����ĺ�ʱ�������߳̽��������߳̽���
	 * �����Ҫ���߳������߳�֮���������Ҫ��join����
	 * join()�����������ǵȴ��̶߳�������
	 * 
	 * �����ǲ�ʹ��join�ķ���
	 */
	public static void main(String[] args) {
		Thread3_18 t1=new Thread3_18();
		t1.start();
		//Thread.Sleep(?);
		System.out.println("���뵱Thread3_18ִ�к���ִ�к���Ĵ���");
		System.out.println("���������sleep�е�ֵ��ȷ��");
	}
	

}
