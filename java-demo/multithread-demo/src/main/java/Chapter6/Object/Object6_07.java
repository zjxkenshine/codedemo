package Chapter6.Object;

public class Object6_07 {
	//�ӳټ���/����ģʽ��ȱ��Ľ������3������ͬ��,�����Ҫ����ͬ��
	
	private static Object6_07 obj;
	
	public Object6_07() {
		// TODO Auto-generated constructor stub
	}
	
	public static Object6_07 getInstance(){
		try{
			if(obj!=null){
			}else{
				Thread.sleep(3000);
				//��Ȼ��Ҫ�����߳�������������Ȼ�з��̰߳�ȫ����
				
				synchronized (Object6_07.class) {
					obj=new Object6_07();
				}
			}
		}catch (InterruptedException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return obj;
	}

}
