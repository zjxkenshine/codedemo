package Chapter3.Object;

import java.io.IOException;
import java.io.PipedWriter;

public class Write3_16 {
	//Êä³öÀà
	
	public void writeMethod(PipedWriter out){
		try{
		   System.out.println("write :");
		   for(int i=0;i<300;i++){
			   String outString=""+(i+1);
			   out.write(outString);
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
