package Chapter3.Thread;

import Chapter3.Object.Object3_29_2;

public class Thread3_29 extends Thread{
	//ֵ�̳����޸�
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		try{
			for(int i=0;i<10;i++){
				System.out.println("���̵߳õ���ֵ��"+Object3_29_2.t.get());
				Thread.sleep(100);
			}
		}catch (InterruptedException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
