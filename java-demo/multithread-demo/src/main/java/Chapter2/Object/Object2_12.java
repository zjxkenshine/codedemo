package Chapter2.Object;

public class Object2_12 {
	//同步代码块一半同步一半异步
	 
	public void longTask(){
		for(int i=0;i<100;i++){                     //异步执行
			System.out.println("nosynchronized threadName="+Thread.currentThread().getName()+" i="+(i+1));
		}
		System.out.println("---------------");
		
		synchronized (this) {                        //同步执行
			for(int i=0;i<100;i++){
				System.out.println("synchronized threadName="+Thread.currentThread().getName()+" i="+(i+1));
			}
		}
	}

}
