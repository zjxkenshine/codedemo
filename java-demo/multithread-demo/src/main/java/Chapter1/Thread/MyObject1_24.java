package Chapter1.Thread;

public class MyObject1_24 {
	//suspend()��resume()ȱ������������ݲ�ͬ��
	
	private String username="1";
	private String password="11";
	public void setValue(String u,String p){
		this.username=u;
		if(Thread.currentThread().getName().equals("a")){        //�˴�ֹͣ�̵߳������ݲ�ͬ��
			System.out.println("ֹͣa�߳�!");
			Thread.currentThread().suspend();
		}
		this.password=p;
	}
	
	public void printUsernamePassword(){
		System.out.println(username+"   "+password);
	}

}
