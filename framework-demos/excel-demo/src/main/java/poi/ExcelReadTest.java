package poi;

import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.joda.time.DateTime;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;

/**
 * POI Excel读测试
 * @author kenshine
 * @create 2020-10-29 11:37
 **/
public class ExcelReadTest {

    private String PATH="D:\\IdeaProjects\\codedemo\\excel-demo\\";


    /**
     * 03xls文件读取
     * @throws IOException
     */
    @Test
    public void testRead03() throws IOException {
        //获取文件流
        FileInputStream fileInputStream=new FileInputStream(PATH+"测试表1.xls");

        //1、创建一个工作簿。使用Excel能操作的都能操作
        Workbook workbook=new HSSFWorkbook(fileInputStream);
        //2、创建一个工作表。表中的设置
        Sheet sheet = workbook.getSheetAt(0);
        //3、获取行
        Row row1=sheet.getRow(0);
        //4、获取列
        Cell cell1_1=row1.getCell(0);
        //读取值时需要注意类型
        //输出(获取字符串类型)
        System.out.println(cell1_1.getStringCellValue());
        //关闭流
        fileInputStream.close();
    }

    /**
     * 07 xlsx文件读取
     * @throws IOException
     */
    @Test
    public void testRead07() throws IOException {
        //获取文件流
        FileInputStream fileInputStream=new FileInputStream(PATH+"测试表2.xlsx");

        //1、创建一个工作簿。使用Excel能操作的都能操作
        Workbook workbook=new XSSFWorkbook(fileInputStream);
        //2、创建一个工作表。表中的设置
        Sheet sheet = workbook.getSheetAt(0);
        //3、获取行
        Row row1=sheet.getRow(0);
        //4、获取列
        Cell cell1_1=row1.getCell(0);
        //读取值时需要注意类型
        //输出(获取字符串类型)
        System.out.println(cell1_1.getStringCellValue());
        //关闭流
        fileInputStream.close();
    }

    /**
     * 读取Excel文档，判断单元格数据类型
     * @throws Exception
     */
    @Test
    public void testCellType() throws Exception{
        //获取文件流
        FileInputStream inputStream = new FileInputStream(PATH+"测试表1.xls");
        //创建一个工作簿
        Workbook workbook=new HSSFWorkbook(inputStream);
        Sheet sheet=workbook.getSheetAt(0);

        //获取标题内容
        Row rowTitle=sheet.getRow(0);
        if(rowTitle!=null){
            //读取该行所有的列
            int cellCount=rowTitle.getPhysicalNumberOfCells();
            for (int cellNum = 0; cellNum < cellCount; cellNum++) {
                //获取单元格
                Cell cell=rowTitle.getCell(cellNum);
                //非空判断
                if(cell!=null){
                    int cellType = cell.getCellType();
                    String cellValue=cell.getStringCellValue();
                    System.out.println(cellValue + " | ");
                }
            }
            System.out.println();
        }
        //获取表中的内容
        //获取行数
        int rowCount=sheet.getPhysicalNumberOfRows();
        //第一行之后
        for (int rowNum = 1; rowNum < rowCount; rowNum++) {
            Row rowData = sheet.getRow(rowNum);
            if(rowData!=null){
                //读取列
                int cellCount = rowTitle.getPhysicalNumberOfCells();
                for (int cellNum = 0; cellNum < cellCount; cellNum++) {
                    System.out.println("[" + ( rowNum + 1 ) + "-" + ( cellNum + 1 ) + "]");
                    //获取单元格
                    Cell cell = rowData.getCell(cellNum);
                    //列数据类型匹配
                    if(cell!=null){
                        int cellType = cell.getCellType();
                        String cellValue = "";
                        switch (cellType){
                            //字符串
                            case HSSFCell.CELL_TYPE_STRING:
                                System.out.println("【STRING】");
                                cellValue =cell.getStringCellValue();
                                break;
                            //布尔
                            case HSSFCell.CELL_TYPE_BOOLEAN:
                                System.out.println("【BOOLEAN】");
                                cellValue = String.valueOf(cell.getBooleanCellValue());
                                break;
                            //空
                            case HSSFCell.CELL_TYPE_BLANK:
                                System.out.println("【BLANK】");
                                break;
                            //数字(日期、普通数字)
                            case HSSFCell.CELL_TYPE_NUMERIC:
                                System.out.println("【NUMERIC】");
                                //日期
                                if(HSSFDateUtil.isCellDateFormatted(cell)){
                                    System.out.print("【日期】");
                                    Date date=cell.getDateCellValue();
                                    cellValue=new DateTime(date).toString("yyyy-MM-dd");
                                }else{
                                    //不是日期格式，防止数字过长
                                    System.out.println("【转换为字符串输出】");
                                    cell.setCellType(HSSFCell.CELL_TYPE_STRING);
                                    cellValue=cell.toString();
                                }
                                break;
                            case HSSFCell.CELL_TYPE_ERROR:
                                System.out.println("【数据类型错误】");
                                break;
                            default:
                        }
                        System.out.println(cellValue);
                    }
                }
            }
        }
        inputStream.close();
    }

    /**
     * Excel 公式，少用，了解即可
     * @throws Exception
     */
    @Test
    public void testFormula() throws Exception{
        FileInputStream inputStream=new FileInputStream(PATH+"公式.xls");
        //读取工作簿
        HSSFWorkbook workbook=new HSSFWorkbook(inputStream);
        //读取工作表
        Sheet sheet=workbook.getSheetAt(0);
        //读取行
        Row row=sheet.getRow(4);
        //获取单元格
        Cell cell=row.getCell(0);
        //拿到计算公式 eval
        FormulaEvaluator formulaEvaluator=new HSSFFormulaEvaluator(workbook);

        //输出单元格内容
        int cellType=cell.getCellType();
        //公式
        if (cellType == Cell.CELL_TYPE_FORMULA) {
            String formula = cell.getCellFormula();
            System.out.println(formula);

            //通过公式计算值
            CellValue evaluate = formulaEvaluator.evaluate(cell);
            String cellValue = evaluate.formatAsString();
            System.out.println(cellValue);
        }

    }
}
