package Chapter2.Object;

public class Object2_06_2S extends Object2_06_2P{
	//synchronized��������,�̳л���,����
	synchronized public void MethodA(){
		try{
			while(i>0){
				i--;
				System.out.println("son print i="+i);
				Thread.sleep(100);
				super.MethodA();
			}
		}catch(InterruptedException e){
			e.printStackTrace();
		}
	}
	
}
