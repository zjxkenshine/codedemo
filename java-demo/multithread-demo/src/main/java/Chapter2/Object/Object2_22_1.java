package Chapter2.Object;

public class Object2_22_1 {
	// ��String�����ص����ԡ���synchronized(String)����������
	
	
	
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