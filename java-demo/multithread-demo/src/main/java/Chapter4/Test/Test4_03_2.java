package Chapter4.Test;

import Chapter4.Object.Service4_03_2;
import Chapter4.Thread.Thread4_03_2;

public class Test4_03_2 {
	
	//���н����ֻ�����111111111
	public static void main(String[] args) {
		Service4_03_2 ser=new Service4_03_2();
		Thread4_03_2 td=new Thread4_03_2(ser);
		td.start();
	}

}
