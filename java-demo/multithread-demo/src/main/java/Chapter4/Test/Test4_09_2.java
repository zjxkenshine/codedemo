package Chapter4.Test;

import Chapter4.Object.Service4_09;

public class Test4_09_2 {
	//非公平锁
	
	/**
	 * 完全不按start顺序打印
	 * @param args
	 */
public static void main(String[] args) {
		
		final Service4_09 ser=new Service4_09(false);             //非公平锁
		
		Runnable runn=new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				System.out.println("********线程"+Thread.currentThread().getName()+"运行了（加锁了）");
				ser.Method();
				
			}
			
		};
		Thread[] th=new Thread[10];
		
		for(int i=0;i<10;i++){
			th[i]=new Thread(runn);
		}
		
        for(int i=0;i<10;i++){
        	th[i].start();
		}
		
	}

}
