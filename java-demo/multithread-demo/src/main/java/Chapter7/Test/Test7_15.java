package Chapter7.Test;

import java.text.SimpleDateFormat;

import Chapter7.Thread.Thread7_15;

public class Test7_15 {
	// ����쳣����2�� ʹ��ThreadLocal��
	
	/*
	 * ʹ��ThreadLocal����ʹ�̰߳󶨵�ָ������ʹ�ø���Ҳ�ܽ�����߳���SimpleDateFormat���쳣
	 * 
	 * ͬһ���߳��ٴ�ʹ�ò��ô����µģ�����һ������Ч�ʸ���
	 */
	
	public static void main(String[] args) {
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
			String[] dateStringList=new String[]{"2017-10-14","2017-07-11","2017-11-20","2017-05-01","2015-11-14"};
			Thread[] tl=new Thread[dateStringList.length];
			for(int i=0;i<tl.length;i++){
				tl[i]=new Thread7_15(sdf, dateStringList[i]);
				
			}
			for(int i=0;i<tl.length;i++){
				tl[i].start();
			}
			
		
	}

}
