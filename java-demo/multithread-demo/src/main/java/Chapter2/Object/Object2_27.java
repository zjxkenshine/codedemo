package Chapter2.Object;

public class Object2_27 {
	//��������ͬ��ʵ��2
	
	static public class InnerClass1{
		public void method1(InnerClass2 class2){
			String threadName=Thread.currentThread().getName();
			synchronized (class2) {
				System.out.println(threadName+"������Class1�е�Method1����");
				for(int i=0;i<10;i++){
					System.out.println("i="+i);
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				System.out.println(threadName+"�뿪��Class1�е�Method1����");
				
			}
		}
		
		public synchronized void method2(){
			String threadName=Thread.currentThread().getName();
			System.out.println(threadName+"������Class1�е�Method2����");
			for(int i=0;i<10;i++){
				System.out.println("i="+i);
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			System.out.println(threadName+"�뿪��Class1�е�Method2����");
		}
		
	}
	
	static public class InnerClass2{
		public synchronized void method3(){
			String threadName=Thread.currentThread().getName();
			System.out.println(threadName+"������Class2�е�Method3����");
			for(int i=0;i<10;i++){
				System.out.println("i="+i);
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			System.out.println(threadName+"�뿪��Class2�е�Method3����");
		}
	}

}
