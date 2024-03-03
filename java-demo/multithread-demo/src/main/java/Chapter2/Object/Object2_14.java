package Chapter2.Object;

public class Object2_14 {
	//验证synchronized(this)代码块是锁定当前对象的
	
	synchronized public void MethodA(){              //加上synchronized变为同步方法
		System.out.println("---------------------------------run other method");
	}
	
	public void MethodB(){
		synchronized(this){
			for(int i=0;i<1000;i++){
				System.out.println("synchronized threadName="+Thread.currentThread().getName()+" i="+(i+1));
			}
		}
	}
}
