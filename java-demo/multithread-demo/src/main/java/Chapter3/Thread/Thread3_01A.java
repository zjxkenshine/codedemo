package Chapter3.Thread;

import Chapter3.Object.Object3_01;

public class Thread3_01A extends Thread{
	//不使用等待/通知机制实现线程通信
	
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
				System.out.println("添加了"+(i+1)+"个元素");
				Thread.sleep(1000);
			}
		}catch(InterruptedException e){
			e.printStackTrace();
		}
	}
	

}
