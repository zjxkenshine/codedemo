package Chapter2.Object;

public class Object2_15_2 {
	//将任意非this对象作为【对象监视器】
	
	private String aaa=new String();
	
	private String bbb=new String();
	
	public void MethodA(){
		try{
			synchronized (aaa) {
				System.out.println("a begin");
				Thread.sleep(3000);
				System.out.println("a end");
			}
		}catch(InterruptedException e){
			e.printStackTrace();
		}
	}
	
	public void MethodB(){
		try{
			synchronized (bbb) {
				System.out.println("b begin");
				Thread.sleep(3000);
				System.out.println("b end");
			}
		}catch(InterruptedException e){
			e.printStackTrace();
		}
	}
	
	synchronized public void MethodC(){
		try{
			System.out.println("c begin");
			Thread.sleep(3000);
			System.out.println("c end");
		}catch(InterruptedException e){
			e.printStackTrace();
		}
	}

}
