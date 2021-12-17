package base.demo01_99.demo01_String_Format;

/**
 * @author ：kenshine
 * @date ：Created in 2021/12/17 23:12
 * @description：
 * @modified By：
 * @version: $
 *
 * String.format()的详细用法
 * https://blog.csdn.net/anita9999/article/details/82346552/
 *
 * test01 基础格式化使用
 * test02 日期装换符的使用
 */
public class test01 {
    /**
     *  format(String format, Object… args)
     *  format(Locale locale, String format, Object… args)
     * 常用格式化占位符：
     * %s  字符串
     * %c  字符类型
     * %b   布尔类型
     * %d   十进制整型
     * %f   浮点
     * %e   指数类型
     * %g   通用浮点
     * %h   散列码
     * %%   百分比
     * %n   换行符
     * %tx 日期与时间类型（x代表不同的日期与时间转换符)
     *
     * 转换符
     * +    为正数或者负数添加符号
     * 0    数字前面补0(加密常用)
     * 空格   在整数之前添加指定数量的空格
     * ,    以“,”对数字分组(常用显示金额)
     * (    使用括号包含负数
     * #    如果是浮点数则包含小数点，如果是16进制或8进制则添加0x或0
     * <    格式化前一个转换符所描述的参数
     * $
     *
     *
     */
    public static void main(String[] args) {
        String str=null;
        str=String.format("Hi,%s", "小超");
        System.out.println(str);
        str=String.format("Hi,%s %s %s", "小超","是个","大帅哥");
        System.out.println(str);

        //printf自带String.format操作
        System.out.printf("字母c的大写是：%c %n", 'C');
        System.out.printf("布尔结果是：%b %n", "小超".equals("帅哥"));
        System.out.printf("100的一半是：%d %n", 100/2);
        System.out.printf("100的16进制数是：%x %n", 100);
        System.out.printf("100的8进制数是：%o %n", 100);
        System.out.printf("50元的书打8.5折扣是：%f 元%n", 50*0.85);
        System.out.printf("上面价格的16进制数是：%a %n", 50*0.85);
        System.out.printf("上面价格的指数表示：%e %n", 50*0.85);
        System.out.printf("上面价格的指数和浮点数结果的长度较短的是：%g %n", 50*0.85);
        System.out.printf("上面的折扣是%d%% %n", 85);
        System.out.printf("字母A的散列码是：%h %n", 'A');
    }
}
