package Chapter3.Thread;

import Chapter3.Object.Object3_02_4;

public class Thread3_02_4B extends Thread{
	private Object obj=new Object();
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		try{
			synchronized (obj) {
				for(int i=0;i<10;i++){
					Object3_02_4.add();
					if(Object3_02_4.size()==5){
						obj.notify();
						System.out.println("已发出通知");
					}
					System.out.println("添加了"+(i+1)+"个元素");
					Thread.sleep(1000);
				}
			}
		}catch(InterruptedException e){
			e.printStackTrace();
		}
	}
	
	public Thread3_02_4B(Object obj) {
		// TODO Auto-generated constructor stub
		this.obj=obj;
	}

}