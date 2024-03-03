package Chapter2.Object;

public class Object2_11 {
	//synchronized(this)解决同步方法的弊端
	
	private String getData1;
	private String getData2;
    public void dolongtask(){
		try{
			System.out.println("task begin");
			Thread.sleep(3000);
			String a="长时间处理任务后从远程返回的值1 threadName ="+Thread.currentThread().getName();
			String b="长时间处理任务后从远程返回的值2 threadName ="+Thread.currentThread().getName();
			synchronized(this){              //同步代码块
				getData1=a;
				getData2=b;
			}
			System.out.println(getData1);
			System.out.println(getData2);
			System.out.println("task end");
			
		}catch(InterruptedException e){
			e.printStackTrace();
		}
	}
}
