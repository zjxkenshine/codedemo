package Chapter7.Object;

public class Service7_03 {
	
	
	//验证BLOCKED状态
	 static public void serviceMethod(){
		 synchronized (Service7_03.class) {
			
			try{
				System.out.println(Thread.currentThread().getName()+"进入了业务方法");
				Thread.sleep(5000);
				Service7_03.class.wait();
				
			}catch (InterruptedException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
	}

}
