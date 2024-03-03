package Chapter3.Object;

import java.util.ArrayList;
import java.util.List;

public class MyStack3_11 {
	//һ������һ���ѣ�������ջ��
	
	//ջ
	
	private List list=new ArrayList<>();
	
	synchronized public void push(){             //����
		try{
			if(list.size()==1){              //��Ϊwhileѭ�����Խ�������ı�����
				this.wait();
			}
			list.add("�κ��ַ���"+Math.random());
			this.notify();
			System.out.println("push="+list.size());
		}catch (InterruptedException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	synchronized public String pop(){
		String returnString="";
		try{
			if(list.size()==0){
				System.out.println("pop�����еģ�"+Thread.currentThread().getName()+"�̳߳ʵȴ�״̬");
				this.wait();
			}
			returnString=""+list.get(0);
			list.remove(0);
			this.notify();
			System.out.println("pop="+list.size());
			
		}catch (InterruptedException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return returnString;
	}

}
