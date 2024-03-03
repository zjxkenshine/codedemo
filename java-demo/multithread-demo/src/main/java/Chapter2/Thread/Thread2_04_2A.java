package Chapter2.Thread;


import Chapter2.Object.Object2_04_2;

public class Thread2_04_2A extends Thread{
	//synchronized方法锁的是这个对象而非方法
		private Object2_04_2 obj;
		
		public Thread2_04_2A(Object2_04_2 obj) {
			super();
			this.obj=obj;
		}

		public void run() {
			super.run();
			obj.methodA();
		}

}
