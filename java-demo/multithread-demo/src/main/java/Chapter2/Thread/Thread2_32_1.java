package Chapter2.Thread;

public class Thread2_32_1 extends Thread{
	//volatile的非原子特性
	
	volatile public static int count;
	private static void addCount(){
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
