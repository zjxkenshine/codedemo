package Chapter2.Object;

public class Object2_02 {
	//实例变量非线程安全
	//两个线程访问【 同一个】对象的同步方法时一定线程安全
	
	private int num=0;                 //实例变量
	
	synchronized public void addI(String username){          //加上synchronized变为同步方法
		try{
			
			if(username.equals("a")){
				num=100;
				System.out.println("a 线程赋值100结束");
				Thread.sleep(1000);
			}else{
				num=200;
				System.out.println("b 线程赋值200结束");
			}
			System.out.println(username+" num="+num);
		}catch(InterruptedException e){
			e.printStackTrace();
		}
	}
}
