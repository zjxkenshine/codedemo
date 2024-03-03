package Chapter2.Object;

public class Object2_05 {
	// �����dirtyRead��
	
	public String username="A";
	public String password="AAA";
	synchronized public void setValue(String username,String password){
		try{
			this.username=username;
			Thread.sleep(5000);
			this.password=password;
			System.out.println("setValue method thread name="+Thread.currentThread().getName()+"  username="+username+", password="+password);
		}catch(InterruptedException e){
			e.printStackTrace();
		}
	}
	
	synchronized public void getValue(){              //ȡֵ������ͬ���������κ�ʱ����õ������,�����������synchronized
		System.out.println("getValue method thread name="+Thread.currentThread().getName()+"  username="+username+", password="+password);
	}
	
}
