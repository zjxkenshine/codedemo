package Chapter2.Object;

public class Object2_12 {
	//ͬ�������һ��ͬ��һ���첽
	 
	public void longTask(){
		for(int i=0;i<100;i++){                     //�첽ִ��
			System.out.println("nosynchronized threadName="+Thread.currentThread().getName()+" i="+(i+1));
		}
		System.out.println("---------------");
		
		synchronized (this) {                        //ͬ��ִ��
			for(int i=0;i<100;i++){
				System.out.println("synchronized threadName="+Thread.currentThread().getName()+" i="+(i+1));
			}
		}
	}

}
