package Chapter2.Object;

import java.util.ArrayList;
import java.util.List;

public class Object2_16_2 {
	//synchronized(�����this����x)����������
	
	private List list=new ArrayList();
	synchronized public void add(String data){
		list.add(data);
	};
	
	synchronized public int getSize(){
		return list.size();
	}

}
