package Chapter7.Test;

import java.text.SimpleDateFormat;

import Chapter1.Thread.Thread1_1;
import Chapter7.Thread.Thread7_13;

public class Test7_13 {
	//SimpleDateFormat�����쳣�����
	
	/**1.SimpleDateFormat��Ҫ�������ڵ�ת�����ʽ���������ڶ��̵߳������ʹ�ô��������������ת��������Ĳ�׼ȷ��
	 *   ��ΪSimpleDateFormat�ಢ�����̰߳�ȫ��
	 *   
	 * 2.�����쳣����ʵ�齫��֤�÷����ڶ��̻߳����µĲ�׼ȷ��
	 *   ʹ�õ�����SimpleDateFormat�ڶ��̻߳����´������ڣ����׳�������ת����������
	 * 
	 * 3.multiple points��������ΪSimpleDateFormat�ಢ�����̰߳�ȫ��
	 * 
	 */
	
	public static void main(String[] args) {
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		String[] dateStringList=new String[]{"2017-10-14","2017-07-11","2017-11-20","2017-05-01","2015-11-14"};
		Thread[] tl=new Thread[dateStringList.length];
		for(int i=0;i<tl.length;i++){
			tl[i]=new Thread7_13(sdf, dateStringList[i]);
			
		}
		for(int i=0;i<tl.length;i++){
			tl[i].start();
		}
		
	}
	

}
