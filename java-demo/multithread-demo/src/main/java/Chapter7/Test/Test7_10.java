package Chapter7.Test;

import Chapter7.Thread.Thread7_10;

public class Test7_10 {
	//线程组内的线程批量停止
	
	/**
	 * 调用线程组ThreadGroup的interrupt()方法时可以将该线程组所有正在运行的线程批量停止
	 */
	
	public static void main(String[] args) {
		try{
			ThreadGroup tg=new ThreadGroup("新线程组");
			for(int i=0;i<5;i++){
				Thread7_10 t1=new Thread7_10(tg, " 线程"+(i+1));
				t1.start();
			}
			
			Thread.sleep(5000);
			tg.interrupt();
			System.out.println("调用了interrupt方法");
			
		}catch (InterruptedException e) {
			// TODO: handle exception
			System.out.println("停止了");
			e.printStackTrace();
		}
	}

}
