package Chapter2.Test;

import Chapter2.Object.Object2_30;

public class Test2_30 {
	//2_30: volatile���ͬ����ѭ��
	
	/**
	 * volatile�ؼ��ֵ����ã� ǿ�ƴӹ�����ջ��ȡ�ñ���ֵ�������Ǵ�˽�����ݶ�ջ��ȡ�ñ���ֵ
	 */
	
	public static void main(String[] args) {
		Object2_30 obj=new Object2_30();
		new Thread(obj).start();
		System.out.println("��Ҫֹͣ��!stopThread="+Thread.currentThread().getName());
		obj.setPrint(false);
	}

}
