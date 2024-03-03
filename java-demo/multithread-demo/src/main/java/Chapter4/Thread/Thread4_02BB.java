package Chapter4.Thread;

import Chapter4.Object.Service4_02;

public class Thread4_02BB extends Thread{
	
	 private Service4_02 ser=new Service4_02();
		
		public Thread4_02BB(Service4_02 ser) {
			// TODO Auto-generated constructor stub
			this.ser=ser;
		}
		
		@Override
		public void run() {
			// TODO Auto-generated method stub
			super.run();
			ser.MethodB();
		}
	

}
