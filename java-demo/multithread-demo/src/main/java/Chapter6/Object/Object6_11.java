package Chapter6.Object;

public class Object6_11 {
	//ʹ��static����ʵ�ֵ���ģʽ
	
	private static Object6_11 ins=null;
	
	public Object6_11() {
		// TODO Auto-generated constructor stub
	}
	
	//static�����
	static{
		ins=new Object6_11();
	}
	
	public static Object6_11 get(){
		return ins;
	}

}
