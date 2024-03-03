package Chapter6.Thread;


import Chapter6.Object.Object6_13;

public class Thread6_13 extends Thread{
	//完善使用enum枚举数据类型实现单例模式
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		for(int i=0;i<5;i++){
			System.out.println(Object6_13.getcon().hashCode());
		}
	}

}
