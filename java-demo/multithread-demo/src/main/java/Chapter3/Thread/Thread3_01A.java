package Chapter3.Thread;

import Chapter3.Object.Object3_01;

public class Thread3_01A extends Thread{
	//��ʹ�õȴ�/֪ͨ����ʵ���߳�ͨ��
	
	private Object3_01 obj=new Object3_01();
	public Thread3_01A(Object3_01 obj) {
		// TODO Auto-generated constructor stub
		this.obj=obj;
	} 
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try{
			for(int i=0;i<10;i++){
				obj.add();
				System.out.println("�����"+(i+1)+"��Ԫ��");
				Thread.sleep(1000);
			}
		}catch(InterruptedException e){
			e.printStackTrace();
		}
	}
	

}
