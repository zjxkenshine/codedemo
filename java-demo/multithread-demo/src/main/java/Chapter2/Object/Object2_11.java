package Chapter2.Object;

public class Object2_11 {
	//synchronized(this)���ͬ�������ı׶�
	
	private String getData1;
	private String getData2;
    public void dolongtask(){
		try{
			System.out.println("task begin");
			Thread.sleep(3000);
			String a="��ʱ�䴦��������Զ�̷��ص�ֵ1 threadName ="+Thread.currentThread().getName();
			String b="��ʱ�䴦��������Զ�̷��ص�ֵ2 threadName ="+Thread.currentThread().getName();
			synchronized(this){              //ͬ�������
				getData1=a;
				getData2=b;
			}
			System.out.println(getData1);
			System.out.println(getData2);
			System.out.println("task end");
			
		}catch(InterruptedException e){
			e.printStackTrace();
		}
	}
}
