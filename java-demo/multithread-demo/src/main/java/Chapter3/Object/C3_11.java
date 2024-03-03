  package Chapter3.Object;

public class C3_11 {
	//一生产与一消费：【操作栈】
	
   private MyStack3_11 ms;
	
	public C3_11(MyStack3_11 ms) {
		// TODO Auto-generated constructor stub
		this.ms=ms;
	}
	
	public void popService(){
		ms.pop();
	}
                                                     
}
