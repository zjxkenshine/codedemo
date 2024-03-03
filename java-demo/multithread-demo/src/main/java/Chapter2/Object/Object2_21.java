package Chapter2.Object;

public class Object2_21 {
	//synchronized(class)代码块
	
	public static void printA(){   //是不是静态方法效果相同
		synchronized (Object2_21.class) {
			try{
				System.out.println("线程 "+Thread.currentThread().getName()+" 在 "+System.currentTimeMillis()+" 时进入方法printA");
				Thread.sleep(2000);
				System.out.println("线程 "+Thread.currentThread().getName()+" 在 "+System.currentTimeMillis()+" 时离开方法printA");
				
			}catch(InterruptedException e){
				e.printStackTrace();
			}
		}
		
	}
	
	public static void printB(){
		synchronized (Object2_21.class) {
			try{
				System.out.println("线程 "+Thread.currentThread().getName()+" 在 "+System.currentTimeMillis()+" 时进入方法printA");
				Thread.sleep(2000);
				System.out.println("线程 "+Thread.currentThread().getName()+" 在 "+System.currentTimeMillis()+" 时离开方法printA");
				
			}catch(InterruptedException e){
				e.printStackTrace();
			}
		}
		
	}

}
