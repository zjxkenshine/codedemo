package Chapter1.Thread;

public class Thread1_18_1 extends Thread{
	//�쳣��ֹͣ�̣߳��鱾�Ƽ���
	
	//for����breakʵ�ֲ����жϣ�for����µ���仹�����ִ��
	public void run(){
		super.run();
			for(int i=0;i<200;i++){
				System.out.println("i="+i);
				if(this.interrupted()){
					System.out.println("�߳���ֹ��!");
					break;
				}
			}
			System.out.println("����for���������䣬�Ƿ�ִ��?");    //����ִ��
	}
	
}
