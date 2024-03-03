package Chapter3.Thread;

public class Thread3_18 extends Thread{
	//Ñ§Ï°joinÇ°µÄÆÌµæ
	
	/* (non-Javadoc)
	 * @see java.lang.Thread#run()
	 */
	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		int seconds=(int)(Math.random()*10000);
		System.out.println(seconds);
		try {
			Thread.sleep(seconds);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
