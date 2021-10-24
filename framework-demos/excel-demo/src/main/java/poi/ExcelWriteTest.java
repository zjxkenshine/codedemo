package poi;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.joda.time.DateTime;
import org.junit.Test;

import java.io.FileOutputStream;
import java.io.IOException;

/**
 * poi Excel写测试
 * @author kenshine
 * @create 2020-10-29 11:25
 **/
public class ExcelWriteTest {

    private String PATH="D:\\IdeaProjects\\codedemo\\excel-demo\\";


    /**
     * Excel03写测试
     * @throws IOException
     */
    @Test
    public void testWrite03() throws IOException {
        //1.创建一个工作簿
        Workbook workbook=new HSSFWorkbook();
        //2.创建一个工作表
        Sheet sheet=workbook.createSheet("sheet1表");
        //3.创建一个行(第一行)
        Row row1=sheet.createRow(0);
        //4.创建一个单元格(第一行第一列)
        Cell cell1_1=row1.createCell(0);
        cell1_1.setCellValue("数量");
        Cell cell1_2=row1.createCell(1);
        cell1_2.setCellValue("1");
        //第二行第一列
        Row row2=sheet.createRow(1);
        Cell cell2_1=row2.createCell(0);
        cell2_1.setCellValue("时间");
        Cell cell2_2=row2.createCell(1);
        String time=new DateTime().toString("yyyy-MM-dd HH:mm:ss");
        cell2_2.setCellValue(time);

        //5.生成一张表   07版本以xls结尾
        FileOutputStream fileOutputStream=new FileOutputStream(PATH+"测试表1.xls");
        workbook.write(fileOutputStream);

        //关闭流
        fileOutputStream.close();
        System.out.println("03版本Excel生成完毕！");

    }

    /**
     * Excel07写测试
     * @throws IOException
     */
    @Test
    public void testWrite07() throws IOException {
        //1.创建一个工作簿
        Workbook workbook=new XSSFWorkbook();
        //2.创建一个工作表
        Sheet sheet=workbook.createSheet("sheet2表");
        //3.创建一个行(第一行)
        Row row1=sheet.createRow(0);
        //4.创建一个单元格(第一行第一列)
        Cell cell1_1=row1.createCell(0);
        cell1_1.setCellValue("数量");
        Cell cell1_2=row1.createCell(1);
        cell1_2.setCellValue("时间");
        //第二行第一列
        Row row2=sheet.createRow(1);
        Cell cell2_1=row2.createCell(0);
        cell2_1.setCellValue("1");
        Cell cell2_2=row2.createCell(1);
        String time=new DateTime().toString("yyyy-MM-dd HH:mm:ss");
        cell2_2.setCellValue(time);

        //5.生成一张表 07版本以xlsx结尾
        FileOutputStream fileOutputStream=new FileOutputStream(PATH+"测试表2.xlsx");
        workbook.write(fileOutputStream);

        //关闭流
        fileOutputStream.close();
        System.out.println("07版本Excel生成完毕！");

    }

    /**
     * 大文件写 HSSF
     *
     * 缺点：最多只能处理65536行，否则会抛出异常
     * 优点：过程中写入缓存，不操作磁盘，最后一次性写入磁盘，速度快
     * @throws IOException
     */
    @Test
    public void testWrite03BigData() throws IOException {
        //时间
        long begin =System.currentTimeMillis();

        //创建一个工作簿
        Workbook workbook=new HSSFWorkbook();
        //创建一个工作表
        Sheet sheet=workbook.createSheet();
        //写入数据
        for (int rowNum = 0; rowNum < 65536; rowNum++) {
            Row row =sheet.createRow(rowNum);
            for(int cellNum = 0;cellNum < 10; cellNum++){
                Cell cell=row.createCell(cellNum);
                cell.setCellValue(cellNum);
            }
        }
        System.out.println("写入完成");
        FileOutputStream fileOutputStream=new FileOutputStream(PATH+"测试表3.xls");
        workbook.write(fileOutputStream);

        //关闭流
        fileOutputStream.close();
        long end=System.currentTimeMillis();
        System.out.println("HSSF生成完毕！时间 = " + (double)(end-begin)/1000 + "秒");


    }

    /**
     * 大文件写 XSSF
     *
     * 缺点：写数据时速度非常慢，非常耗内存，也会发生内存溢出，如100万条
     * 优点：可以写较大的数据量，如20万条
     * @throws IOException
     */
    @Test
    public void testWrite07BigData() throws IOException {
        //时间
        long begin =System.currentTimeMillis();

        //创建一个工作簿
        Workbook workbook=new XSSFWorkbook();
        //创建一个工作表
        Sheet sheet=workbook.createSheet();
        //写入数据
        for (int rowNum = 0; rowNum < 70000; rowNum++) {
            Row row =sheet.createRow(rowNum);
            for(int cellNum = 0;cellNum < 10; cellNum++){
                Cell cell=row.createCell(cellNum);
                cell.setCellValue(cellNum);
            }
        }
        System.out.println("写入完成");
        FileOutputStream fileOutputStream=new FileOutputStream(PATH+"测试表4.xlsx");
        workbook.write(fileOutputStream);

        //关闭流
        fileOutputStream.close();
        long end=System.currentTimeMillis();
        System.out.println("XSSF生成完毕！时间 = " + (double)(end-begin)/1000 + "秒");


    }


    /**
     *  大文件写SXSSF
     *
     *  优点：可以写非常大的数据量，如100万条甚至更多条，写数据速度快，占用更少的内存
     *  注意：
     *      过程中会产生临时文件，需要清理临时文件
     *      默认有100条记录被保存在内存中，如果超过这数量，则最前面的数据被写入临时文件
     *      如果想自定义内存中数据的数量，可以使用new SXSSFWorkbook ( 数量 )
     * @throws IOException
     */
    @Test
    public void testWrite07SXSSF() throws IOException {
        //时间
        long begin =System.currentTimeMillis();

        //创建一个工作簿
        SXSSFWorkbook workbook=new SXSSFWorkbook();
        //创建一个工作表
        Sheet sheet=workbook.createSheet();
        //写入数据
        for (int rowNum = 0; rowNum < 70000; rowNum++) {
            Row row =sheet.createRow(rowNum);
            for(int cellNum = 0;cellNum < 10; cellNum++){
                Cell cell=row.createCell(cellNum);
                cell.setCellValue(cellNum);
            }
        }
        System.out.println("写入完成");
        FileOutputStream fileOutputStream=new FileOutputStream(PATH + "测试表5.xlsx");
        workbook.write(fileOutputStream);
        fileOutputStream.close();
        // 清除临时文件！
        workbook.dispose();
        long end=System.currentTimeMillis();
        System.out.println("XSSF生成完毕！时间 = " + (double)(end-begin)/1000 + "秒");

    }


}
