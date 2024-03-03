package Chapter3.Test;

import Chapter3.Object.Object3_25_1;
import Chapter3.Thread.Thread3_25_1A;
import Chapter3.Thread.Thread3_25_1B;

public class Test3_25_1 {
	//验证线程变量的隔离性
	
	//每个线程都能取出自己的值
	
	public static void main(String[] args) {
		try{
			Thread3_25_1A ta=new Thread3_25_1A();
			Thread3_25_1B tb=new Thread3_25_1B();
			ta.start();
			tb.start();
			for(int i=0;i<100;i++){
				Object3_25_1.t1.set("MAIN thread"+(i+1));
				System.out.println("MAIN thread get value="+Object3_25_1.t1.get());
				Thread.sleep(200);
			}

			
		}catch (InterruptedException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
