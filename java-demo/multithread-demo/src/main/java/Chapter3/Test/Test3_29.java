package Chapter3.Test;

import Chapter3.Object.Object3_29_2;
import Chapter3.Thread.Thread3_29;

public class Test3_29 {
	//ֵ�̳����޸�
	
	/**1.����ͨ��
	 * protected Object childValue(Object parentValue){
		    return parentValue+" ������";
	   }
	 * ��ʽ�����̼̳߳�����ӻ��޸�ֵ
	 * 
	 * 
	 * 2.��������̵߳õ�ֵ��ͬʱ,���̶߳�InheritableThreadLocal�е�ֵ���и���
	 *   ��ô���̵߳õ���ֵ���Ǿ�ֵ
	 * 
	 */
	
	public static void main(String[] args) {
		try{
			for(int i=0;i<10;i++){
				System.out.println(" �ڸ��߳��еõ���ֵ="+Object3_29_2.t.get());
				Thread.sleep(100);
			}
			Thread.sleep(5000);
			Thread3_29 tb=new Thread3_29();
			tb.start();
		}catch (InterruptedException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
