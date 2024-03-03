package Chapter1.Thread;

public class Thread1_30 extends Thread{
	private int i=0;
	
	public void run(){
		try{
			while(true){
				i++;
				System.out.println("i="+i);
				Thread.sleep(500);
			}
		}catch(InterruptedException e){
			e.printStackTrace();
		}
	}
}
