package Chapter2.Object;

public class Object2_04_1 {
	//synchronized�������������������Ƿ���
	
	synchronized public void methodA(){            //����synchronized������������ʹ�߳�ͬ�����Ŷӣ�
		try{
			System.out.println("begin method A threadName="+Thread.currentThread().getName());
			Thread.sleep(2000);
			System.out.println("end!");
		}catch(InterruptedException e){
			e.printStackTrace();
		}
	}

}
