package Chapter7.Object;

public class Service7_03 {
	
	
	//��֤BLOCKED״̬
	 static public void serviceMethod(){
		 synchronized (Service7_03.class) {
			
			try{
				System.out.println(Thread.currentThread().getName()+"������ҵ�񷽷�");
				Thread.sleep(5000);
				Service7_03.class.wait();
				
			}catch (InterruptedException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
	}

}
