package Chapter2.Object;

import java.util.ArrayList;
import java.util.List;

public class Object2_16_1 {
	//synchronized(�����this����x)����������
	
	private List list=new ArrayList();
	
	synchronized public void add(String username){
		System.out.println("ThreadName="+Thread.currentThread().getName()+"ִ����add����");
		list.add(username);
		System.out.println("ThreadName="+Thread.currentThread().getName()+"�˳���add����");
	}

}
