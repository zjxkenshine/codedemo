package Chapter2.Object;

public class Object2_09 {
	//synchronized�����ı׶�--��ʱ���Ŷ�
	
	private String getData1;
	private String getData2;
	synchronized public void dolongtask(){
		try{
			System.out.println("task begin");
			Thread.sleep(3000);
			getData1="��ʱ�䴦��������Զ�̷��ص�ֵ1 threadName ="+Thread.currentThread().getName();
			getData2="��ʱ�䴦��������Զ�̷��ص�ֵ2 threadName ="+Thread.currentThread().getName();
			System.out.println(getData1);
			System.out.println(getData2);
			System.out.println("task end");
			
		}catch(InterruptedException e){
			e.printStackTrace();
		}
	}

}
