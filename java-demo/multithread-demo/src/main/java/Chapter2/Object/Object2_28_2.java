package Chapter2.Object;

public class Object2_28_2 {
	//������ĸı�
	public void methodA(Userinfo2_28_2 info){
		synchronized (info) {
			 try {
				System.out.println(Thread.currentThread().getName());
			    info.setUsername("123456");
		   
				Thread.sleep(2000);
				System.out.println("end! time="+System.currentTimeMillis());
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    
		}
	}
	

}
