package Chapter2.Object;

public class Object2_04_2 {
	//synchronized�������������������Ƿ���
	
		synchronized public void methodA(){          
			try{
				System.out.println("begin method A threadName="+Thread.currentThread().getName());
				Thread.sleep(2000);
				System.out.println("end!");
			}catch(InterruptedException e){
				e.printStackTrace();
			}
		}
		
		synchronized public void methodB(){                   
			//����synchronized��Ҫ��A�߳�ִ����A����������B�̲߳���ִ�и÷�����������
			try{
				System.out.println("begin method B threadName="+Thread.currentThread().getName());
				Thread.sleep(2000);
				System.out.println("end!");
			}catch(InterruptedException e){
				e.printStackTrace();
			}
		}
}
