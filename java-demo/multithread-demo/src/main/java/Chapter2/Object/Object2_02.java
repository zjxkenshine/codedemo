package Chapter2.Object;

public class Object2_02 {
	//ʵ���������̰߳�ȫ
	//�����̷߳��ʡ� ͬһ���������ͬ������ʱһ���̰߳�ȫ
	
	private int num=0;                 //ʵ������
	
	synchronized public void addI(String username){          //����synchronized��Ϊͬ������
		try{
			
			if(username.equals("a")){
				num=100;
				System.out.println("a �̸߳�ֵ100����");
				Thread.sleep(1000);
			}else{
				num=200;
				System.out.println("b �̸߳�ֵ200����");
			}
			System.out.println(username+" num="+num);
		}catch(InterruptedException e){
			e.printStackTrace();
		}
	}
}
