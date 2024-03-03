package Chapter3.Object;

import java.util.ArrayList;
import java.util.List;

public class MyStack3_11 {
	//一生产与一消费：【操作栈】
	
	//栈
	
	private List list=new ArrayList<>();
	
	synchronized public void push(){             //增加
		try{
			if(list.size()==1){              //改为while循环可以解决条件改变问题
				this.wait();
			}
			list.add("任何字符串"+Math.random());
			this.notify();
			System.out.println("push="+list.size());
		}catch (InterruptedException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	synchronized public String pop(){
		String returnString="";
		try{
			if(list.size()==0){
				System.out.println("pop操作中的："+Thread.currentThread().getName()+"线程呈等待状态");
				this.wait();
			}
			returnString=""+list.get(0);
			list.remove(0);
			this.notify();
			System.out.println("pop="+list.size());
			
		}catch (InterruptedException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return returnString;
	}

}
