package Chapter2.Object;

public class Object2_01 {
	//方法内的变量为线程安全
	
	public void addI(String username){
		try{
			int num=0;                 //方法内部变量
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
