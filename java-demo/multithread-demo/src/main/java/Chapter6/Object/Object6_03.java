package Chapter6.Object;

public class Object6_03 {
	//�ӳټ���/����ģʽ����
	
	public static Object6_03 obj;
	
	public Object6_03() {
		// TODO Auto-generated constructor stub
	}
	
	public static Object6_03 getInstance(){
		//�ӳټ���
		if(obj!=null){
		}else{
			obj=new Object6_03();
		}
		return obj;
	}

}
