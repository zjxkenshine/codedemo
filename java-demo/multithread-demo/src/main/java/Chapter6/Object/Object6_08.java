package Chapter6.Object;

public class Object6_08 {
	//�ӳټ���/����ģʽ��ȱ��Ľ������4��DCL˫���������(Double-Check Locking)
	
	private volatile static Object6_08 obj;
	
	private Object6_08() {
		// TODO Auto-generated constructor stub
	}
	
	

	public static Object6_08 getInstance() {
		// TODO Auto-generated method stub
		try{
			if(obj!=null){
				
			}else{
				Thread.sleep(3000);
				synchronized (Object6_08.class) {
					if(obj==null){
						obj=new Object6_08();
					}
				}
			}
			
		}catch (InterruptedException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return obj;
	}
	

}
