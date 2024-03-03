package Chapter7.Object;

import java.text.SimpleDateFormat;

public class Tool7_15 {
	// ����쳣����2�� ʹ��ThreadLocal��
	
	private static ThreadLocal<SimpleDateFormat> tsdf=new ThreadLocal<SimpleDateFormat>();
	
	public static SimpleDateFormat getsimpledateformat(String datepatterm){
		SimpleDateFormat sdf=null;
		sdf=tsdf.get();
		if(sdf==null){
			sdf=new SimpleDateFormat(datepatterm);
			tsdf.set(sdf);
		}
		return sdf;
		
	}

}
