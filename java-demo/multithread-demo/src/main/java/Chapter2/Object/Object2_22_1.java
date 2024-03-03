package Chapter2.Object;

public class Object2_22_1 {
	// 【String常量池的特性】给synchronized(String)带来的例外
	
	
	
	public static void print(String param){
		try{
			synchronized(param){
				while(true){
					System.out.println(Thread.currentThread().getName());
					Thread.sleep(1000);
				}
			}
		}catch(InterruptedException e){
			e.printStackTrace();
		}
	}
	

}