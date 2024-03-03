package Chapter3.Object;

import java.util.ArrayList;
import java.util.List;

public class Object3_01 {
	//不使用等待/通知机制实现线程通信
	
	private List list=new ArrayList();
	
	public void add(){
		list.add("哈哈哈");
	}
	
	public int size(){
		return list.size();
	}

}
