package Chapter1.Test;

public class Test1_16_2 {
	//this.interrupted():判断当前线程是否中断，执行后清除中断标记
	//停止main线程（当前线程的情况）
	public static void main(String[] args) {
		Thread.currentThread().interrupt();    //main线程停止标记
		System.out.println(Thread.currentThread().getName()+"是否存活？="+Thread.currentThread().isAlive());    //打上停止标记线程仍然存活
		System.out.println(Thread.currentThread().getName()+"是否停止？="+Thread.interrupted());    //由main线程调用
		System.out.println(Thread.currentThread().getName()+"是否停止？="+Thread.interrupted());    
		//第一次清除标记，所以第二次是false
	}

}
