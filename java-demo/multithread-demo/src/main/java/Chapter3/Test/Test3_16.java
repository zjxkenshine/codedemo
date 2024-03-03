package Chapter3.Test;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.io.PipedReader;
import java.io.PipedWriter;

import Chapter3.Object.Read3_16;
import Chapter3.Object.Write3_16;
import Chapter3.Thread.Thread3_16A;
import Chapter3.Thread.Thread3_16B;

public class Test3_16 {
	//通过管道进行线程间通信：字符流char
	
	public static void main(String[] args) throws InterruptedException {
		try{
			Write3_16 write=new Write3_16();
			Read3_16  red=new Read3_16();
			
			PipedReader input=new PipedReader();
			PipedWriter out=new PipedWriter();
			
		//	input.connect(out);
			out.connect(input);           //使两个线程间产生通信，这样才能将数据进行输入输出
			
			Thread3_16B t1=new Thread3_16B(red, input);
			t1.start();
			
			Thread.sleep(1000);
			
			Thread3_16A t2=new Thread3_16A(write, out);
			t2.start();
			
		}catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
