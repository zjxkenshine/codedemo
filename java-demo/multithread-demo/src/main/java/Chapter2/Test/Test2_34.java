package Chapter2.Test;

import Chapter2.Object.Object2_34;
import Chapter2.Thread.Thread2_34;

public class Test2_34 {
	//原子类也并非完全安全
	//原子类在具有逻辑性的情况下输出结果也具有随机性
	
	public static void main(String[] args) {
		try{
			Object2_34 obj=new Object2_34();
			Thread2_34[] array=new Thread2_34[5];
			for(int i=0;i<array.length;i++){
				array[i]=new Thread2_34(obj);
			}
			for(int i=0;i<array.length;i++){
				array[i].start();
			}
			Thread.sleep(1000);
			System.out.println(obj.along.get());
			
			
		}catch(InterruptedException e){
			e.printStackTrace();
		}
	}

}
