package Chapter1.Thread;

public class Thread1_18_2 extends Thread{
	//�쳣��ֹͣ�̣߳��鱾�Ƽ���
	
		//for����breakʵ�ֲ����жϣ�for����µ���仹�����ִ��
		public void run(){
			super.run();
			try{
				for(int i=0;i<200;i++){
					System.out.println("i="+i);
					if(this.interrupted()){
						throw new InterruptedException("�߳���ֹ��");
					}
				}
				System.out.println("����for���������䣬�Ƿ�ִ��");
			}catch(InterruptedException e){
				System.out.println("�ɹ�����thread��catch");
				e.printStackTrace();
			}
		}

}
