package Chapter2.Object;

public class Object2_20_2 {
	//��̬ͬ��synchronized����2
	
	synchronized public static void MethodA(){
		try{
			System.out.println("�߳� "+Thread.currentThread().getName()+" �� "+System.currentTimeMillis()+" ʱ���뷽��printA");
			Thread.sleep(2000);
			System.out.println("�߳� "+Thread.currentThread().getName()+" �� "+System.currentTimeMillis()+" ʱ�뿪����printA");
			
		}catch(InterruptedException e){
			e.printStackTrace();
		}
	}
	
	synchronized public static void MethodB(){
		try{
			System.out.println("�߳� "+Thread.currentThread().getName()+" �� "+System.currentTimeMillis()+" ʱ���뷽��printB");
			Thread.sleep(2000);
			System.out.println("�߳� "+Thread.currentThread().getName()+" �� "+System.currentTimeMillis()+" ʱ�뿪����printB");
			
		}catch(InterruptedException e){
			e.printStackTrace();
		}
		
	}
	
	synchronized public void MethodC(){
		try{
			System.out.println("�߳� "+Thread.currentThread().getName()+" �� "+System.currentTimeMillis()+" ʱ���뷽��C");
			Thread.sleep(2000);
			System.out.println("�߳� "+Thread.currentThread().getName()+" �� "+System.currentTimeMillis()+" ʱ�뿪����C");
			
		}catch(InterruptedException e){
			e.printStackTrace();
		}
		
	}

}
