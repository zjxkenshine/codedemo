package Chapter2.Test;

import Chapter2.Thread.Thread2_31;

public class Test2_31 {
	//volatile����첽��ѭ��
	
	/**1.��ʹ��volatile�ؼ�����_server�����³�����ѭ���� _server������һֱ��˽�ж�ջ�����У���ͼ���鱾P122��
	 * 	   ��setRunning�ı���ǹ�����ջ��ֵ���޷����߳�ȡ�����������volatile�ؼ���ǿ�ƶ�ȡ������ջ��ֵ
	 * 
	 * 2.������ѭ����Ҫ��˽�ж�ջֵ�빫����ջ�е�ֵ��ͬ����ɵ�
	 * 	 ʹ��volatile�ؼ���������ʵ�������ڶ���߳�֮��Ŀɼ��ԣ���volatile�ؼ��ֵ�����ȱ���ǡ���֧��ԭ���ԡ�
	 * 
	 * 3.synchronized�ؼ�����volatile�ؼ��ֵıȽ�
	 *  a. �ؼ���volatile���߳�ͬ����������ʵ�֣�����volatile���ܱ�synchronized�ã�
	 *     ��volatileֻ�����α�����synchronized�������η���������顣JDK�汾���£�synchronized�����ܲ���������
	 * 
	 *  b. ���̷߳���volatile����������������synchronized��������
	 *  
	 *  c. volatile�ܱ�֤���ݵĿɼ��ԣ������ܱ�֤ԭ����
	 *     synchronized���Ա�֤ԭ���ԣ�Ҳ���Լ�ӱ�֤�ɼ��ԣ���Ϊ���Ὣ˽���ڴ�͹����ڴ��е�������ͬ��
	 *     
	 *  d. �ؼ���volatile������Ǳ����ڶ���߳�֮��Ŀɼ��ԣ�
	 *     ��synchronized�ؼ��ֽ�����Ƕ���߳�֮�������Դ��ͬ����
	 * 
	 */
	
	public static void main(String[] args) {
		try{
			Thread2_31 thread=new Thread2_31();
			thread.start();
			Thread.sleep(1000);             //thread�߳�ֹͣ1��
			thread.setRunning(false);
			
			System.out.println("�Ѿ���ֵΪfalse");
			
		}catch(InterruptedException e){
			e.printStackTrace();
		}
	}

}
