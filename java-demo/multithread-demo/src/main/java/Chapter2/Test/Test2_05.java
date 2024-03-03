package Chapter2.Test;

import Chapter2.Object.Object2_05;
import Chapter2.Thread.Thread2_05;

public class Test2_05 {
	// 脏读（dirtyRead）
	
	public static void main(String[] args) {
		try{
			Object2_05 obj=new Object2_05();
			Thread2_05 thread=new Thread2_05(obj);
			thread.start();
			Thread.sleep(200);         //结果受此值影响
			obj.getValue();
		}catch(InterruptedException e){
			e.printStackTrace();
		}
	}

}
