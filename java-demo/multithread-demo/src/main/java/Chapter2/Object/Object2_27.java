package Chapter2.Object;

public class Object2_27 {
	//内置类与同步实验2
	
	static public class InnerClass1{
		public void method1(InnerClass2 class2){
			String threadName=Thread.currentThread().getName();
			synchronized (class2) {
				System.out.println(threadName+"进入了Class1中的Method1方法");
				for(int i=0;i<10;i++){
					System.out.println("i="+i);
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				System.out.println(threadName+"离开了Class1中的Method1方法");
				
			}
		}
		
		public synchronized void method2(){
			String threadName=Thread.currentThread().getName();
			System.out.println(threadName+"进入了Class1中的Method2方法");
			for(int i=0;i<10;i++){
				System.out.println("i="+i);
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			System.out.println(threadName+"离开了Class1中的Method2方法");
		}
		
	}
	
	static public class InnerClass2{
		public synchronized void method3(){
			String threadName=Thread.currentThread().getName();
			System.out.println(threadName+"进入了Class2中的Method3方法");
			for(int i=0;i<10;i++){
				System.out.println("i="+i);
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			System.out.println(threadName+"离开了Class2中的Method3方法");
		}
	}

}
