package Chapter1.Thread;

public class Thread1_18_2 extends Thread{
	//异常法停止线程（书本推荐）
	
		//for语句加break实现部分中断，for语句下的语句还会继续执行
		public void run(){
			super.run();
			try{
				for(int i=0;i<200;i++){
					System.out.println("i="+i);
					if(this.interrupted()){
						throw new InterruptedException("线程终止啦");
					}
				}
				System.out.println("这是for语句后面的语句，是否执行");
			}catch(InterruptedException e){
				System.out.println("成功进入thread的catch");
				e.printStackTrace();
			}
		}

}
