package Chapter3.Test;

public class Test3_02_2 {
	//测试有对象监视器的wait，但没有notify方法
	
	//wait后的语句均不执行
	
	public static void main(String[] args) {
		try{
			String lock=new String();
			System.out.println("synchronized语句上面");
			synchronized (lock) {
				System.out.println("synchronized第一行");
				lock.wait();
				System.out.println("wait下面的代码");
			}
			System.out.println("synchronized语句下面的代码");
		}catch(InterruptedException e){
			e.printStackTrace();
		}
	}

}
