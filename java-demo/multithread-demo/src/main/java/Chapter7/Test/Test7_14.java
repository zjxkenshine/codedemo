package Chapter7.Test;

import java.text.SimpleDateFormat;

import Chapter7.Thread.Thread7_14;

public class Test7_14 {
	//解决异常方法1：创建多个SimpleDateFormat对象
	
	public static void main(String[] args) {
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		String[] dateStringList=new String[]{"2017-10-14","2017-07-11","2017-11-20","2017-05-01","2015-11-14"};
		Thread[] tl=new Thread[dateStringList.length];
		for(int i=0;i<tl.length;i++){
			tl[i]=new Thread7_14(sdf, dateStringList[i]);
			
		}
		for(int i=0;i<tl.length;i++){
			tl[i].start();
		}
		
	}

}
