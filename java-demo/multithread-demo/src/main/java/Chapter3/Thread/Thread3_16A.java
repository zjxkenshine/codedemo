package Chapter3.Thread;


import java.io.PipedWriter;

import Chapter3.Object.Write3_16;

public class Thread3_16A extends Thread{
	
	//管道输出流线程
	
		private Write3_16 write;
		private PipedWriter out;
		
		public Thread3_16A( Write3_16 write ,PipedWriter out) {
			// TODO Auto-generated constructor stub
			this.out=out;
			this.write=write;
		}
		
		@Override
		public void run() {
			// TODO Auto-generated method stub
			super.run();
			write.writeMethod(out);
		}

}
