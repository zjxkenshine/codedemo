package Chapter2.Object;

public class Object2_20_3 {
	//静态同步synchronized方法3
	
	synchronized public static void printA(){
		try{
			System.out.println("线程 "+Thread.currentThread().getName()+" 在 "+System.currentTimeMillis()+" 时进入方法printA");
			Thread.sleep(2000);
			System.out.println("线程 "+Thread.currentThread().getName()+" 在 "+System.currentTimeMillis()+" 时离开方法printA");
			
		}catch(InterruptedException e){
			e.printStackTrace();
		}
	}
	
	synchronized public static void printB(){
		try{
			System.out.println("线程 "+Thread.currentThread().getName()+" 在 "+System.currentTimeMillis()+" 时进入方法printB");
			Thread.sleep(2000);
			System.out.println("线程 "+Thread.currentThread().getName()+" 在 "+System.currentTimeMillis()+" 时离开方法printB");
			
		}catch(InterruptedException e){
			e.printStackTrace();
		}
	}

}
