package Chapter2.Object;

public class Object2_21 {
	//synchronized(class)�����
	
	public static void printA(){   //�ǲ��Ǿ�̬����Ч����ͬ
		synchronized (Object2_21.class) {
			try{
				System.out.println("�߳� "+Thread.currentThread().getName()+" �� "+System.currentTimeMillis()+" ʱ���뷽��printA");
				Thread.sleep(2000);
				System.out.println("�߳� "+Thread.currentThread().getName()+" �� "+System.currentTimeMillis()+" ʱ�뿪����printA");
				
			}catch(InterruptedException e){
				e.printStackTrace();
			}
		}
		
	}
	
	public static void printB(){
		synchronized (Object2_21.class) {
			try{
				System.out.println("�߳� "+Thread.currentThread().getName()+" �� "+System.currentTimeMillis()+" ʱ���뷽��printA");
				Thread.sleep(2000);
				System.out.println("�߳� "+Thread.currentThread().getName()+" �� "+System.currentTimeMillis()+" ʱ�뿪����printA");
				
			}catch(InterruptedException e){
				e.printStackTrace();
			}
		}
		
	}

}
