package Chapter3.Object;

import java.io.IOException;
import java.io.PipedReader;

public class Read3_16 {
	// ‰»Î¿‡
	
	public void readMethod(PipedReader input){
		try{
			System.out.println("read :");
			char[] bytelist=new char[20];
			int length=input.read(bytelist);
			while(length!=-1){
				String newString=new String(bytelist, 0, length);
				System.out.print(newString);
				length=input.read(bytelist);
			}
			System.out.println();
			input.close();
			
		}catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
