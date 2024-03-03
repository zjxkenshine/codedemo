package Chapter3.Test;

import Chapter3.Object.C3_11;
import Chapter3.Object.MyStack3_11;
import Chapter3.Object.P3_11;
import Chapter3.Thread.Thread3_11A;
import Chapter3.Thread.Thread3_11B;

public class Test3_11 {
	//一生产与一消费：【操作栈】
	
	//交替输出
	public static void main(String[] args) {
		MyStack3_11 ms=new MyStack3_11();
		P3_11 p=new P3_11(ms);
		C3_11 c=new C3_11(ms);
		Thread3_11A t1=new Thread3_11A(p);
		Thread3_11B t2=new Thread3_11B(c);
		t1.start();
		t2.start();
	}
	
	

}
