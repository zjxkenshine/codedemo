package Chapter2.Test;

import Chapter2.Object.Object2_07;
import Chapter2.Thread.Thread2_07A;
import Chapter2.Thread.Thread2_07B;

public class Test2_07 {
	//��������쳣ʱ���������е������Զ��ͷ�
	
	//a�����쳣�ͷ�����b���뷽��������ӡ
	public static void main(String[] args) {
		
		try{
			Object2_07 obj=new Object2_07();
			Thread2_07A a=new Thread2_07A(obj);
			a.setName("a");
			a.start();
			Thread.sleep(500);
			Thread2_07B b=new Thread2_07B(obj);
			b.setName("b");
			b.start();
			
		}catch(InterruptedException e){
			e.printStackTrace();
		}
	}
}
