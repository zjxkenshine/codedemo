package Chapter7.Object;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Tool7_14 {
	//����쳣����1���������SimpleDateFormat����
	
	/**
	 * ͨ��Tool�м���ﵽÿ�δ����µ�SimpleDateFormat�����Ч��
	 * @param formatePattern
	 * @param dateString
	 * @return
	 * @throws ParseException
	 */
	
	public static Date parse(String formatePattern,String dateString) throws ParseException{
		return new SimpleDateFormat(formatePattern).parse(dateString);
	}
	
	public static String formate(String formatePattern,Date dateString) throws ParseException{
		return new SimpleDateFormat(formatePattern).format(dateString);
	}

}
