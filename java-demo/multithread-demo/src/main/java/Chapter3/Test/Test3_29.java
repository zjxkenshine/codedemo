package Chapter3.Test;

import Chapter3.Object.Object3_29_2;
import Chapter3.Thread.Thread3_29;

public class Test3_29 {
	//值继承再修改
	
	/**1.可以通过
	 * protected Object childValue(Object parentValue){
		    return parentValue+" ？？？";
	   }
	 * 方式在子线程继承中添加或修改值
	 * 
	 * 
	 * 2.如果在子线程得到值的同时,主线程对InheritableThreadLocal中的值进行更改
	 *   那么子线程得到的值还是旧值
	 * 
	 */
	
	public static void main(String[] args) {
		try{
			for(int i=0;i<10;i++){
				System.out.println(" 在父线程中得到的值="+Object3_29_2.t.get());
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
