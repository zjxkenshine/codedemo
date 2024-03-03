package Chapter7.Test;

import java.text.SimpleDateFormat;

import Chapter7.Thread.Thread7_15;

public class Test7_15 {
	// 解决异常方法2： 使用ThreadLocal类
	
	/*
	 * 使用ThreadLocal类能使线程绑定到指定对象，使用该类也能解决多线程下SimpleDateFormat的异常
	 * 
	 * 同一个线程再次使用不用创建新的，比上一个方法效率更高
	 */
	
	public static void main(String[] args) {
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
			String[] dateStringList=new String[]{"2017-10-14","2017-07-11","2017-11-20","2017-05-01","2015-11-14"};
			Thread[] tl=new Thread[dateStringList.length];
			for(int i=0;i<tl.length;i++){
				tl[i]=new Thread7_15(sdf, dateStringList[i]);
				
			}
			for(int i=0;i<tl.length;i++){
				tl[i].start();
			}
			
		
	}

}
