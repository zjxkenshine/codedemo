package Chapter2.Object;

public class Object2_14 {
	//��֤synchronized(this)�������������ǰ�����
	
	synchronized public void MethodA(){              //����synchronized��Ϊͬ������
		System.out.println("---------------------------------run other method");
	}
	
	public void MethodB(){
		synchronized(this){
			for(int i=0;i<1000;i++){
				System.out.println("synchronized threadName="+Thread.currentThread().getName()+" i="+(i+1));
			}
		}
	}
}
