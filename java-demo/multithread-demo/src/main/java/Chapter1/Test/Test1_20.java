package Chapter1.Test;

import Chapter1.Thread.Thread1_20;

public class Test1_20 {
	//stop()��������ֹͣ�����Ƽ�ʹ�ã�����stop()������
	/**ʹ��stop()��
	 * 1.���׳�java.lang.ThreadDeath�쳣��������ʽ��׽
	 * 2.��ʹһЩ�����Թ����ò������
	 * 3.��������Ķ���������������ݵò���ͬ�������������ݲ�һ�µĽ��
	 *   (ʹsychornizedʧЧ)
	**/
	public static void main(String[] args) {
		try{
			Thread1_20 thread=new Thread1_20();
			thread.start();
			Thread.sleep(8000);
			thread.stop();
			
		}catch(InterruptedException e){
			e.printStackTrace();
		}
	}

}
