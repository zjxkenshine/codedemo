package Chapter2.Object;

public class Object2_23 {
	//ͬ��synchronized�������޵ȴ�����  
	/*
	synchronized public void methodA(){
		System.out.println("methodA begin");
		boolean isCountinueRun=true;
		while(isCountinueRun){
		}
		System.out.println("methodA end");
	}
	
	synchronized public void methodB(){
		System.out.println("methodB begin");
		System.out.println("methodB end");
	}*/
//------------------ʹ��ͬ���������------------------------------------//

	 public void methodA(){
		 synchronized ("AAA") {
			System.out.println("methodA begin");
			boolean isCountinueRun=true;
			while(isCountinueRun){
			}
			System.out.println("methodA end");
		}
	}
	
  public void methodB(){
	  synchronized ("BBB") {
		System.out.println("methodB begin");
		System.out.println("methodB end");
	  }
	}
	
}
