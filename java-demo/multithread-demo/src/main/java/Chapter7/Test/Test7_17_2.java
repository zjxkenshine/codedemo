package Chapter7.Test;

import Chapter7.Thread.Thread7_17_2;
import Chapter7.Thread.ThreadGroup7_17_2;

public class Test7_17_2 {
	//�߳����ڴ����쳣
	
	public static void main(String[] args) {
		ThreadGroup7_17_2 group=new ThreadGroup7_17_2("�߳���");
		Thread7_17_2[] tlist=new Thread7_17_2[10];
		
		for(int i=0;i<tlist.length;i++){
			tlist[i]=new Thread7_17_2(group, "�߳�"+(i+1),"1");
			tlist[i].start();
		}
		
		Thread7_17_2 th=new Thread7_17_2(group, "�����߳�", "a");
		th.start();
		
	}


}
