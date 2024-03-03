package Chapter3.Test;

import Chapter3.Object.Object3_27_2;
import Chapter3.Thread.Thread3_27;

public class Test3_27 {
	//验证多个线程的初始值
	
	//各线程拥有各自的初始值
	
	public static void main(String[] args) {
		try{
			for(int i=0;i<10;i++){
				System.out.println("MAIN线程中得到的值="+Object3_27_2.t.get());
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
