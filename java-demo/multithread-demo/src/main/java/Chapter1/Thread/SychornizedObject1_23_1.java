package Chapter1.Thread;

public class SychornizedObject1_23_1 {
	
	//suspend()与resume()缺点例子：独占公共同步对象
	
	synchronized public void printString(){
		System.out.println("begin");
		if(Thread.currentThread().getName().equals("a")){
			System.out.println("a线程永远暂停了");
			Thread.currentThread().suspend();
		}
		System.out.println("end!");
	}

}
