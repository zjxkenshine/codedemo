package Chapter6.Object;

import java.io.ObjectStreamException;
import java.io.Serializable;

public class Object6_10 implements Serializable{
	//���л��뷴���л��ĵ���ģʽʵ��
	
	private static final long serialVersionUID=4448L;
	
	//�ڲ��෽��
	private static class Object6_10Handler{
		private static final Object6_10 obj=new Object6_10();
	}
	
	public Object6_10() {
		// TODO Auto-generated constructor stub
	}
	
	public static Object6_10 getInstance(){
		System.out.println("getInstance"+Object6_10Handler.obj.hashCode());
		return Object6_10Handler.obj;
	}
	
	//�����⼸���������벻��
	
	protected Object readResolve() throws ObjectStreamException{
		System.out.println("������readResolve()����");
		System.out.println("readResolve"+Object6_10Handler.obj.hashCode());
		return Object6_10Handler.obj;
	}

}
