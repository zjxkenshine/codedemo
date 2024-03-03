package Chapter7.Thread;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import Chapter7.Object.Tool7_14;

public class Thread7_14 extends Thread{
	//解决异常方法1：创建多个SimpleDateFormat对象
	
	private SimpleDateFormat ref;
	private String dateString;
	
	public Thread7_14(SimpleDateFormat ref,String dateString) {
		// TODO Auto-generated constructor stub
		super();
		this.ref=ref;
		this.dateString=dateString;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		try{
			Date dateRef=Tool7_14.parse("yyyy-MM-dd", dateString);
			String DateString=Tool7_14.formate("yyyy-MM-dd", dateRef);
			if(!DateString.equals(dateString)){
				System.out.println("ThreadName="+this.getName()+"转换出错了， 日期字符串="+dateString+",转换成日期为="+DateString);
			}
			
		}catch (ParseException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
