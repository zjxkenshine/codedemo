package Chapter3.Test;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

import Chapter3.Object.Read3_15;
import Chapter3.Object.Write3_15;
import Chapter3.Thread.Thread3_15A;
import Chapter3.Thread.Thread3_15B;

public class Test3_15 {
	//通过管道进行线程间通信：字节流
	
	/**1.java提供了各种各样的输入/输出流Stream,其中管道流(pipeStream)是一种特殊的流，
	 *   用于在不同的线程间传递数据，无需临时文件
	 * 
	 * 2.JDK提供了4个类：
	 *   PipedInputStream和PipedOutputStream
	 *   PipedReader和PipedWriter
	 * @throws InterruptedException 
	 */
	
	//结果:输出了两次，一次是input输出的，一次是out输出的
	 public static void main(String[] args) throws InterruptedException {
		try{
			Write3_15 write=new Write3_15();
			Read3_15  red=new Read3_15();
			
			PipedInputStream input=new PipedInputStream();
			PipedOutputStream out=new PipedOutputStream();
			
			//	input.connect(out);
			out.connect(input);           //使两个线程间产生通信，这样才能将数据进行输入输出
			
			Thread3_15B t1=new Thread3_15B(red, input);
			t1.start();
			
			Thread.sleep(1000);
			
			Thread3_15A t2=new Thread3_15A(write, out);
			t2.start();
			
		}catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
