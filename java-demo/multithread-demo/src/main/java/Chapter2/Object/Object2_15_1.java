package Chapter2.Object;

public class Object2_15_1 {
	//�������this������Ϊ�������������
	
	private String username;
	private String password;
	private String anyString=new String();
	
	public void setUsernamePassword(String username,String password){
		try{
			synchronized(anyString){
				System.out.println("�߳�����Ϊ��"+Thread.currentThread().getName()+"��"+System.currentTimeMillis()+"����ͬ����");
				this.username=username;
				Thread.sleep(2000);
				this.password=password;
				System.out.println("�߳�����Ϊ��"+Thread.currentThread().getName()+"��"+System.currentTimeMillis()+"�뿪ͬ����");
			}
		}catch(InterruptedException e){
			e.printStackTrace();
		}
	}

}
