package Chapter2.Object;

public class Object2_20_3 {
	//��̬ͬ��synchronized����3
	
	synchronized public static void printA(){
		try{
			System.out.println("�߳� "+Thread.currentThread().getName()+" �� "+System.currentTimeMillis()+" ʱ���뷽��printA");
			Thread.sleep(2000);
			System.out.println("�߳� "+Thread.currentThread().getName()+" �� "+System.currentTimeMillis()+" ʱ�뿪����printA");
			
		}catch(InterruptedException e){
			e.printStackTrace();
		}
	}
	
	synchronized public static void printB(){
		try{
			System.out.println("�߳� "+Thread.currentThread().getName()+" �� "+System.currentTimeMillis()+" ʱ���뷽��printB");
			Thread.sleep(2000);
			System.out.println("�߳� "+Thread.currentThread().getName()+" �� "+System.currentTimeMillis()+" ʱ�뿪����printB");
			
		}catch(InterruptedException e){
			e.printStackTrace();
		}
	}

}
