package Chapter3.Thread;

import Chapter3.Object.Object3_01;

public class Thread3_01B extends Thread{
	//不使用等待/通知机制实现线程通信
	
	private Object3_01 obj=new Object3_01();
	public Thread3_01B(Object3_01 obj) {
		// TODO Auto-generated constructor stub
		this.obj=obj;
	} 
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try{
			while(true){
				if(obj.size()==5){
					System.out.println("size=5,b线程退出");
					throw new InterruptedException();
				}
			}
		}catch(InterruptedException e){
			e.printStackTrace();
		}
	}

}
