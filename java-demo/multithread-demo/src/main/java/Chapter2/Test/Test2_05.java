package Chapter2.Test;

import Chapter2.Object.Object2_05;
import Chapter2.Thread.Thread2_05;

public class Test2_05 {
	// �����dirtyRead��
	
	public static void main(String[] args) {
		try{
			Object2_05 obj=new Object2_05();
			Thread2_05 thread=new Thread2_05(obj);
			thread.start();
			Thread.sleep(200);         //����ܴ�ֵӰ��
			obj.getValue();
		}catch(InterruptedException e){
			e.printStackTrace();
		}
	}

}
