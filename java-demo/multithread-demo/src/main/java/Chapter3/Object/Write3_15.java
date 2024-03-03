package Chapter3.Object;

import java.io.IOException;
import java.io.PipedOutputStream;

public class Write3_15 {
	
	public void writeMethod(PipedOutputStream out){
		try{
		   System.out.println("write :");
		   for(int i=0;i<300;i++){
			   String outString=""+(i+1);
			   out.write(outString.getBytes());
			//   System.out.print(outString);
		   }
		   System.out.println();
		   out.close();
		}catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
