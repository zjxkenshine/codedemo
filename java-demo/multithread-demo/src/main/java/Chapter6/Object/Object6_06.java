package Chapter6.Object;

public class Object6_06 {
	//�ӳټ���/����ģʽ��ȱ��Ľ������2��ʹ��ͬ�������
	
	private static Object6_06 obj=new Object6_06();
	
	public Object6_06() {
		// TODO Auto-generated constructor stub
	}
	
	public static Object6_06 getInstance(){
		try{
			synchronized (Object6_06.class) {
				if(obj!=null){
					
				}else{
					Thread.sleep(3000);
					obj=new Object6_06();
				}
			}
			
		}catch (InterruptedException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return obj;
	}

}
