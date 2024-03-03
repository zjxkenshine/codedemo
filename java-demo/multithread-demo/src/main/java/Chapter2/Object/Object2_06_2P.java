package Chapter2.Object;

public class Object2_06_2P {
	//synchronized锁的重入,继承环境,父类
	
	public int i=10;
	synchronized public void MethodA(){
		try{
			i--;
			System.out.println("parent print i="+i);
			Thread.sleep(100);
		}catch(InterruptedException e){
			e.printStackTrace();
		}
	}
}
