package Chapter6.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import Chapter6.Object.Object6_10;

public class Test6_10 {
	//���л��뷴���л��ĵ���ģʽʵ��
	
	/**
	 * ���������ͬһ��������Ҫ�ڷ����л���ʹ��readResolve()
	 * @param args
	 */
	
	public static void main(String[] args) {
		try{
			Object6_10 obj=new Object6_10().getInstance();
			FileOutputStream fosRef=new FileOutputStream(new File("666.txt"));
			ObjectOutputStream oosRef=new ObjectOutputStream(fosRef);
			oosRef.writeObject(obj);
			oosRef.close();
			fosRef.close();
			
			System.out.println(obj.hashCode());
			
			FileInputStream fisRef=new FileInputStream("666.txt");
			ObjectInputStream oisRef=new ObjectInputStream(fisRef);
			Object6_10 obj1=(Object6_10) oisRef.readObject();
			System.out.println(obj1.hashCode());
			oisRef.close();
			fisRef.close();
			
			
			
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
