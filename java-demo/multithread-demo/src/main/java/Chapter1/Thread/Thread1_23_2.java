package Chapter1.Thread;

public class Thread1_23_2 extends Thread {
	//suspend()与resume()缺点例子：独占同步锁
	private long i=0;
	
	public void run(){
		while(true){
			i++;
			System.out.println(i);       //去掉这行则不会出现println独占问题，可以输出main end!
		}
	}
	
	
}
