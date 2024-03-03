package Chapter3.Object;

import java.util.ArrayList;
import java.util.List;

public class MyStack3_12 {
	
	private List list=new ArrayList<>();
	
	synchronized public void push(){             //����
		try{
			while(list.size()==1){              //��Ϊwhileѭ�����Խ�������ı�����
				this.wait();
			}
			list.add("�κ��ַ���"+Math.random());
			this.notifyAll();                     //��ֹ����
			System.out.println("push="+list.size());
		}catch (InterruptedException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	synchronized public String pop(){
		String returnString="";
		try{
			while(list.size()==0){
				System.out.println("pop�����еģ�"+Thread.currentThread().getName()+"�̳߳ʵȴ�״̬");
				this.wait();
			}
			returnString=""+list.get(0);
			list.remove(0);
			this.notifyAll();
			System.out.println("pop="+list.size());
			
		}catch (InterruptedException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return returnString;
	}

}
