package Chapter6.Object;

public class Object6_02 {
	//��������/����ģʽ
	
	private static Object6_02 obj=new Object6_02();     //��ǰ����
	
	private Object6_02() {
		// TODO Auto-generated constructor stub
	}
	
	public static Object6_02 getInstance(){
		//�˴���汾����������
		//ȱ���ǲ���������ʵ����������ΪgetInstance����û��ͬ�������ܻ���ַ��̰߳�ȫ
		
		return obj;
		
	}
	
	

}
