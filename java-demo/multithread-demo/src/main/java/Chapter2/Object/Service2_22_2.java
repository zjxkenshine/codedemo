package Chapter2.Object;

public class Service2_22_2 {
	//��String�����ص����ԡ���synchronized(String)����������
 
	public static void print(Object2_22_2 obj){
		synchronized (obj) {
			while(true){
				System.out.println(Thread.currentThread().getName());
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
	}

}