package Chapter2.Object;

public class Object2_10 {
	//synchronizedͬ��������ʹ��
	
	public void MethodA(){
		try{
			synchronized(this){            //ͬ�������
				System.out.println("begin time="+System.currentTimeMillis());
				Thread.sleep(2000);
				System.out.println("end time="+System.currentTimeMillis());
			}
		}catch(InterruptedException e){
			e.printStackTrace();
		}
		
	}
}
