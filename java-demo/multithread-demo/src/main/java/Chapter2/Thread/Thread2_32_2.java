package Chapter2.Thread;

public class Thread2_32_2 extends Thread{
	//volatile的非原子特性
	
	volatile public static int count;        //volatile可以不加
	synchronized static private void addCount(){         //添加static锁定类
		for(int i=0;i<1000;i++){
			count++;
		}
		System.out.println("count="+count);
	}
	
	public void run() {
		// TODO Auto-generated method stub
		addCount();
	}

}
