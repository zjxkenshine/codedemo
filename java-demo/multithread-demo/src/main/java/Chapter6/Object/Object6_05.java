package Chapter6.Object;

public class Object6_05 {
	//�ӳټ���/����ģʽ��ȱ��Ľ������1������synchronize�ؼ���
	
	private static Object6_05 obj;
	
	public Object6_05() {
		// TODO Auto-generated constructor stub
	}
	
	synchronized public static Object6_05 getInstance(){
		try{
			if(obj!=null){
			}else{
				//ģ�ⴴ������֮ǰ��һЩ׼������
				Thread.sleep(3000);
				obj=new Object6_05();
			}
		}catch (InterruptedException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return obj;
	}

}
