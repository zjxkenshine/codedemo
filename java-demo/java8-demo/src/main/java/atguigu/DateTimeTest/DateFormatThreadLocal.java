package atguigu.DateTimeTest;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author ：kenshine
 * @date ：Created in 2021/10/24 19:07
 * @description：时间格式化
 * @modified By：
 * @version: $
 */
public class DateFormatThreadLocal {
    private static final ThreadLocal<DateFormat> df = ThreadLocal.withInitial(() -> new SimpleDateFormat("yyyy-MM-dd"));

    public static Date convert(String source) throws ParseException {
        return df.get().parse(source);
    }

}
