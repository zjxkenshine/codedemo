package Chapter6.Object;

public class Object6_09 {
	//ʹ�þ�̬������ʵ�ֵ���ģʽ
	
	//�ڲ��෽ʽ
	private static class Object6_09Handler{
		private static Object6_09 obj=new Object6_09();
	}
	
	public Object6_09() {
		// TODO Auto-generated constructor stub
	}
	
	public static Object6_09 getInstance(){
		return Object6_09Handler.obj;
	}
	

}
