package Chapter2.Object;

public class Object2_01 {
	//�����ڵı���Ϊ�̰߳�ȫ
	
	public void addI(String username){
		try{
			int num=0;                 //�����ڲ�����
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
