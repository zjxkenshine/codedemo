package Chapter2.Object;

public class Object2_26 {
	//内置类与同步实验1
	
	static public class Inner{
		public void MethodA(){
			synchronized("非this"){
				for(int i=1;i<=10;i++){
					System.out.println(Thread.currentThread().getName()+"  i="+i);
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
		
		public synchronized void MethodB() throws InterruptedException{
			for(int i=11;i<20;i++){
				System.out.println(Thread.currentThread().getName()+"  i="+i);
				Thread.sleep(100);
			}
		}
	}

}
