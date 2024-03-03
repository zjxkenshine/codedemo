package Chapter7.Test;

import Chapter7.Thread.Thread7_17_2;
import Chapter7.Thread.ThreadGroup7_17_2;

public class Test7_17_2 {
	//线程组内处理异常
	
	public static void main(String[] args) {
		ThreadGroup7_17_2 group=new ThreadGroup7_17_2("线程组");
		Thread7_17_2[] tlist=new Thread7_17_2[10];
		
		for(int i=0;i<tlist.length;i++){
			tlist[i]=new Thread7_17_2(group, "线程"+(i+1),"1");
			tlist[i].start();
		}
		
		Thread7_17_2 th=new Thread7_17_2(group, "报错线程", "a");
		th.start();
		
	}


}
