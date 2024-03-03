package Chapter3.Test;

import Chapter3.Object.Add3_08;
import Chapter3.Object.Substract3_08;
import Chapter3.Thread.Thread3_08A;
import Chapter3.Thread.Thread3_08B;

public class Test3_08 {
	//等待wait的条件发生变化
	
	//wait等待的条件发生变化，也容易造成程序逻辑的混乱,更改substract方法
	
	public static void main(String[] args) throws InterruptedException {
		String lock=new String("");
		Add3_08 add=new Add3_08(lock);
		Substract3_08 sub=new Substract3_08(lock);
		Thread3_08B t1=new Thread3_08B(sub);
		t1.setName("减操作1");
		t1.start();
		Thread3_08B t2=new Thread3_08B(sub);
		t2.setName("减操作2");
		t2.start();
		Thread.sleep(1000);
		Thread3_08A t3=new Thread3_08A(add);
		t3.setName("加操作1");
		t3.start();
	}

}
