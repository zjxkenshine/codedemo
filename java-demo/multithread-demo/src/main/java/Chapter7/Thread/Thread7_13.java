package Chapter7.Thread;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Thread7_13 extends Thread{
	//SimpleDateFormat出现异常的情况
	
	private SimpleDateFormat sdf;
	private String dateString;
	
	public Thread7_13(SimpleDateFormat sdf,String dateString) {
		// TODO Auto-generated constructor stub
		super();
		this.sdf=sdf;
		this.dateString=dateString;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		try{
			System.out.println(dateString);
			Date dateRef=sdf.parse(dateString);
			String newDateString=sdf.format(dateRef).toString();
			if(!newDateString.equals(dateString)){
				System.out.println("线程"+Thread.currentThread().getName()+"转换出错了,日期字符串="+dateString+",转换后字符串="+newDateString);
			}
			
		}catch (ParseException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	

}
