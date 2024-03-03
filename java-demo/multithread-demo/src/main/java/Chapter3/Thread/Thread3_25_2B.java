package Chapter3.Thread;

import java.util.Date;

import Chapter3.Object.Object3_25_2;

public class Thread3_25_2B extends Thread{
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		try{
			for(int i=0;i<20;i++){
				if(Object3_25_2.td.get()==null){
					Object3_25_2.td.set(new Date());
				}
				System.out.println("B Thread:"+Object3_25_2.td.get().getTime());
				Thread.sleep(100);
			}
			
		}catch (InterruptedException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
