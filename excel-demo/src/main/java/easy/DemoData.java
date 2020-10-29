package easy;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @author kenshine
 * @create 2020-10-29 16:07
 * 实体类
 **/
@Data
public class DemoData {
    @ExcelProperty(value = "字符串标题",index = 0)
    private String string;
    @ExcelProperty(value = "日期标题",index = 1)
    private Date date;
    /**
     * index为3则会空一列
     */
    @ExcelProperty(value = "数字标题",index = 2)
    private Double doubleData;
    /**
     * 忽略这个字段
     */
    @ExcelIgnore
    private String ignore;
}