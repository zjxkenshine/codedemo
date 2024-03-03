package Chapter7.Test;


public class Test7_06 {
	//线程对象关联线程组：多级关联
	
	/**1.多级关联就是父对象中有子对象，子对象中再创建子对象，也就是出现子孙对象
	 * 
	 * 2.此种方法在开发中不常见，线程树过于复杂反而不利于线程对象的管理，
	 *   但是JDK提供了支持多级关联的线程树结构
	 * 
	 */
	
	public static void main(String[] args) {
	    //在main线程组中添加一个线程组tg1,在tg1中添加线程对象Z
		//方法activeGroupCount()和activeCount()de值不是固定的
		//是环境中的一个快照
		
		ThreadGroup mainGrop=Thread.currentThread().getThreadGroup();
		ThreadGroup tg=new ThreadGroup(mainGrop,"666");
		Runnable runn=new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				
				try {
					System.out.println("runMethod");
					Thread.sleep(10000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		};
		Thread newtd=new Thread(tg,runn);
		newtd.setName("Z");
		newtd.start();            //必须启动才会归到TG线程组中
		
		ThreadGroup[] listgroup=new ThreadGroup[Thread.currentThread().getThreadGroup().activeCount()];
		
		Thread.currentThread().getThreadGroup().enumerate(listgroup);
		System.out.println("main线程组有多少个子线程组"+listgroup.length+"   名字为："+listgroup[0].getName());
		
		Thread[] listTd=new Thread[listgroup[0].activeCount()];
		listgroup[0].enumerate(listTd);
		System.out.println(listTd[0].getName());
		
	}

}
