package Chapter3.Test;

import Chapter3.Object.Object3_27_2;
import Chapter3.Thread.Thread3_27;

public class Test3_27 {
	//��֤����̵߳ĳ�ʼֵ
	
	//���߳�ӵ�и��Եĳ�ʼֵ
	
	public static void main(String[] args) {
		try{
			for(int i=0;i<10;i++){
				System.out.println("MAIN�߳��еõ���ֵ="+Object3_27_2.t.get());
				Thread.sleep(100);
			}
			Thread.sleep(5000);
			Thread3_27 tb=new Thread3_27();
			tb.start();
		}catch (InterruptedException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
