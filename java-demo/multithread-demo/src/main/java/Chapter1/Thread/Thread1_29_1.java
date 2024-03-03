package Chapter1.Thread;

public class Thread1_29_1 extends Thread{
	//线程优先级高运行得快
	private int count =0;
	
	public int getCount(){
		return count;
	}
	
	public void run(){
		while(true){
			count++;
		}
	}
}
