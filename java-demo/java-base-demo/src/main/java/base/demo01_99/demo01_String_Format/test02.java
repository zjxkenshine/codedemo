package base.demo01_99.demo01_String_Format;

import java.util.Date;

/**
 * @author ：kenshine
 * @date ：Created in 2021/12/17 23:23
 * @description：
 * @modified By：
 * @version: $
 *
 * 日期格式化符
 */
public class test02 {
    public static void main(String[] args) {
        Date date=new Date();
        //c的使用 包括全部日期和时间信息
        System.out.printf("全部日期和时间信息：%tc%n",date);
        //f的使用 “年-月-日”格式
        System.out.printf("年-月-日格式：%tF%n",date);
        //d的使用 “月/日/年”格式
        System.out.printf("月/日/年格式：%tD%n",date);
        //r的使用 “HH:MM:SS PM”格式（12时制）
        System.out.printf("HH:MM:SS PM格式（12时制）：%tr%n",date);
        //t的使用 “HH:MM:SS”格式（24时制）
        System.out.printf("HH:MM:SS格式（24时制）：%tT%n",date);
        //R的使用 “HH:MM”格式（24时制）
        System.out.printf("HH:MM格式（24时制）：%tR",date);
    }
}
