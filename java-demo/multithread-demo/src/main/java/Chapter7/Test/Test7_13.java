package Chapter7.Test;

import java.text.SimpleDateFormat;

import Chapter1.Thread.Thread1_1;
import Chapter7.Thread.Thread7_13;

public class Test7_13 {
	//SimpleDateFormat出现异常的情况
	
	/**1.SimpleDateFormat主要负责日期的转换与格式化，但是在多线程的情况下使用此类容易造成数据转换及处理的不准确性
	 *   因为SimpleDateFormat类并不是线程安全的
	 *   
	 * 2.出现异常：本实验将验证该方法在多线程环境下的不准确性
	 *   使用单例的SimpleDateFormat在多线程环境下处理日期，极易出现日期转换错误的情况
	 * 
	 * 3.multiple points出错是因为SimpleDateFormat类并不是线程安全的
	 * 
	 */
	
	public static void main(String[] args) {
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		String[] dateStringList=new String[]{"2017-10-14","2017-07-11","2017-11-20","2017-05-01","2015-11-14"};
		Thread[] tl=new Thread[dateStringList.length];
		for(int i=0;i<tl.length;i++){
			tl[i]=new Thread7_13(sdf, dateStringList[i]);
			
		}
		for(int i=0;i<tl.length;i++){
			tl[i].start();
		}
		
	}
	

}
