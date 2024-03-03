package Chapter1.Test;

import Chapter1.Thread.Thread1_22;

public class Test1_22 {
	//ÔÝÍ£Ïß³Ì£ºsuspend()¹ÒÆð£¬resume()»Ö¸´
	
	public static void main(String[] args) {
		try{
			Thread1_22 thread=new Thread1_22();
			thread.start();
			Thread.sleep(3000);
			
			//A¶Î
			thread.suspend();  //ÔÝÍ£
			System.out.println("A="+System.currentTimeMillis()+"  i="+thread.getI());
			Thread.sleep(3000);
			System.out.println("A="+System.currentTimeMillis()+"  i="+thread.getI());
			
			//B¶Î
			thread.resume();  //»Ö¸´
			Thread.sleep(3000);
			
			//C¶Î
			thread.suspend(); //ÔÝÍ£
			System.out.println("B="+System.currentTimeMillis()+"  i="+thread.getI());
			Thread.sleep(3000);
			System.out.println("B="+System.currentTimeMillis()+"  i="+thread.getI());
			
		}catch(InterruptedException e){
			e.printStackTrace();
		}
	}

}
