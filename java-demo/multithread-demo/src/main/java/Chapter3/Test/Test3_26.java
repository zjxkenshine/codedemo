package Chapter3.Test;

import Chapter3.Object.Object3_26;

public class Test3_26 {
	//���get���س�ʼֵΪnull������
	
	
	public static Object3_26 t=new Object3_26();
	
	public static void main(String[] args) {
		if(t.get()==null){
			System.out.println("δ�Ź�ֵ");
			t.set("�ҵ�ֵ");
		}
		System.out.println(t.get());
		System.out.println(t.get());
	}

}
