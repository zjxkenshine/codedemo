package Chapter3.Test;

import Chapter3.Thread.Thread3_23A;
import Chapter3.Thread.Thread3_23B;

public class Test3_23 {
	//����join()����Ĵ�����ǰ���У���������
	
	/**
	 * ��ʱjoin��Ĵ�����ǰ��tbִ��
	 * 
	 * ������ͣ�(�鱾P189-P191)
	 * 
	 * join�ٴεõ���ʱ�Ѿ��������룬�Զ��ͷŵ���ʧЧ
	 * join��������������
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		try{
			Thread3_23B tb=new Thread3_23B();
			Thread3_23A ta=new Thread3_23A(tb);
			ta.start();
			tb.start();
			tb.join(2000);               //��ʱ��䳤��ֱ����join()����������join(long)�ɽ��
			System.out.println("main ����������");
		}catch(InterruptedException e){
			e.printStackTrace();
		}
	}

}
