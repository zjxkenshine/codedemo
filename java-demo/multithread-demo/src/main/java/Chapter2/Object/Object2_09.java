package Chapter2.Object;

public class Object2_09 {
	//synchronized方法的弊端--长时间排队
	
	private String getData1;
	private String getData2;
	synchronized public void dolongtask(){
		try{
			System.out.println("task begin");
			Thread.sleep(3000);
			getData1="长时间处理任务后从远程返回的值1 threadName ="+Thread.currentThread().getName();
			getData2="长时间处理任务后从远程返回的值2 threadName ="+Thread.currentThread().getName();
			System.out.println(getData1);
			System.out.println(getData2);
			System.out.println("task end");
			
		}catch(InterruptedException e){
			e.printStackTrace();
		}
	}

}
