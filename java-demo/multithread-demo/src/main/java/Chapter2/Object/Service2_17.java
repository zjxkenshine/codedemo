package Chapter2.Object;

public class Service2_17 {
	//synchronized(�����this����x)������֤1��      ����߳�ͬʱִ��synchronized(x){}ͬ�������ʱ��ͬ��Ч��
	
	public void MethodA(Object2_17 obj){
		synchronized(obj){
			try{
				System.out.println("����methodA�õ�����ʱ����"+System.currentTimeMillis()+" �����߳���"+Thread.currentThread().getName());
				Thread.sleep(2000);
				System.out.println("����methodA�ͷ�����ʱ����"+System.currentTimeMillis()+" �����߳���"+Thread.currentThread().getName());
			}catch(InterruptedException e){
				e.printStackTrace();
			}
		}
	}

}
