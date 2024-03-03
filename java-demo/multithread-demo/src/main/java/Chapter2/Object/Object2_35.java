package Chapter2.Object;

public class Object2_35 {
	//synchronized代码块有volatile同步功能          
	
	private boolean isRun=true;
	public void runMethod(){
		while(isRun){
	//		synchronized ("AAA") {               //内修可视,_server服务器环境下
	//		}
		}
		System.out.println("停了");
	}
	public void stopMethod(){
		isRun=false;
	}

}
