package Chapter2.Object;

public class Object2_20_2 {
	//静态同步synchronized方法2
	
	synchronized public static void MethodA(){
		try{
			System.out.println("线程 "+Thread.currentThread().getName()+" 在 "+System.currentTimeMillis()+" 时进入方法printA");
			Thread.sleep(2000);
			System.out.println("线程 "+Thread.currentThread().getName()+" 在 "+System.currentTimeMillis()+" 时离开方法printA");
			
		}catch(InterruptedException e){
			e.printStackTrace();
		}
	}
	
	synchronized public static void MethodB(){
		try{
			System.out.println("线程 "+Thread.currentThread().getName()+" 在 "+System.currentTimeMillis()+" 时进入方法printB");
			Thread.sleep(2000);
			System.out.println("线程 "+Thread.currentThread().getName()+" 在 "+System.currentTimeMillis()+" 时离开方法printB");
			
		}catch(InterruptedException e){
			e.printStackTrace();
		}
		
	}
	
	synchronized public void MethodC(){
		try{
			System.out.println("线程 "+Thread.currentThread().getName()+" 在 "+System.currentTimeMillis()+" 时进入方法C");
			Thread.sleep(2000);
			System.out.println("线程 "+Thread.currentThread().getName()+" 在 "+System.currentTimeMillis()+" 时离开方法C");
			
		}catch(InterruptedException e){
			e.printStackTrace();
		}
		
	}

}
