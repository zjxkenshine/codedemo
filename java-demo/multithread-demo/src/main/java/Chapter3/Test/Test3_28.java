package Chapter3.Test;

import Chapter3.Object.Object3_28_2;
import Chapter3.Thread.Thread3_28;

public class Test3_28 {
	//InheritableThreadLocalֵ�̳�
	
	public static void main(String[] args) {
		try{
			for(int i=0;i<10;i++){
				System.out.println(" �ڸ��߳��еõ���ֵ="+Object3_28_2.t.get());
				Thread.sleep(100);
			}
			Thread.sleep(5000);
			Thread3_28 tb=new Thread3_28();
			tb.start();
		}catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
