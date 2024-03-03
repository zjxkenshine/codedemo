package Chapter7.Object;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Tool7_14 {
	//解决异常方法1：创建多个SimpleDateFormat对象
	
	/**
	 * 通过Tool中间类达到每次创建新的SimpleDateFormat对象的效果
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
