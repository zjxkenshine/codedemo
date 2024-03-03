package Chapter3.Test;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

import Chapter3.Object.Read3_15;
import Chapter3.Object.Write3_15;
import Chapter3.Thread.Thread3_15A;
import Chapter3.Thread.Thread3_15B;

public class Test3_15 {
	//ͨ���ܵ������̼߳�ͨ�ţ��ֽ���
	
	/**1.java�ṩ�˸��ָ���������/�����Stream,���йܵ���(pipeStream)��һ�����������
	 *   �����ڲ�ͬ���̼߳䴫�����ݣ�������ʱ�ļ�
	 * 
	 * 2.JDK�ṩ��4���ࣺ
	 *   PipedInputStream��PipedOutputStream
	 *   PipedReader��PipedWriter
	 * @throws InterruptedException 
	 */
	
	//���:��������Σ�һ����input����ģ�һ����out�����
	 public static void main(String[] args) throws InterruptedException {
		try{
			Write3_15 write=new Write3_15();
			Read3_15  red=new Read3_15();
			
			PipedInputStream input=new PipedInputStream();
			PipedOutputStream out=new PipedOutputStream();
			
			//	input.connect(out);
			out.connect(input);           //ʹ�����̼߳����ͨ�ţ��������ܽ����ݽ����������
			
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
