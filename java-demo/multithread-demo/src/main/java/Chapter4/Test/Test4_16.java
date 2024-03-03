package Chapter4.Test;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Test4_16 {
	//用Condition实现顺序执行
	
	volatile public static int nextPrintWho=1;
	
	private static ReentrantLock lock=new ReentrantLock();
	final private static Condition con1=lock.newCondition();
	final private static Condition con2=lock.newCondition();
	final private static Condition con3=lock.newCondition();
	
	public static void main(String[] args) {
		Thread t1=new Thread(){
			public void run() {
				try{
					lock.lock();
					while(nextPrintWho!=1){
						con1.await();
					}
					for(int i=0;i<3;i++){
						System.out.println("ThreadA "+(i+1));
					}
					nextPrintWho=2;
					con2.signalAll();
					
				}catch (InterruptedException e) {
					// TODO: handle exception
					e.printStackTrace();
				}finally{
					lock.unlock();
				}
				
			};
		};
		
		Thread t2=new Thread(){
			@Override
			public void run() {
				// TODO Auto-generated method stub
				super.run();
				try{
					lock.lock();
					while(nextPrintWho!=2){
						con1.await();
					}
					for(int i=0;i<3;i++){
						System.out.println("ThreadB "+(i+1));
					}
					nextPrintWho=3;
					con3.signalAll();
				}catch (InterruptedException e) {
					// TODO: handle exception
					e.printStackTrace();
				}finally{
					lock.unlock();
				}
			}
		};
		
		Thread t3=new Thread(){
			@Override
			public void run() {
				// TODO Auto-generated method stub
				super.run();
				try{
					lock.lock();
					while(nextPrintWho!=3){
						con1.await();
					}
					for(int i=0;i<3;i++){
						System.out.println("ThreadC "+(i+1));
					}
					nextPrintWho=1;
					con1.signalAll();
				}catch (InterruptedException e) {
					// TODO: handle exception
					e.printStackTrace();
				}finally{
					lock.unlock();
				}
			}
		};
		
		Thread[] ta=new Thread[5];
		Thread[] tb=new Thread[5];
		Thread[] tc=new Thread[5];
		
		for(int i=0;i<5;i++){
			ta[i]=new Thread(t1);
			tb[i]=new Thread(t2);
			tc[i]=new Thread(t3);
			ta[i].start();
			tb[i].start();
			tc[i].start();
		}
		
	}
}
