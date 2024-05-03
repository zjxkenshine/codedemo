package com.kenshine.myexcel;

import com.github.liaochong.myexcel.core.DefaultExcelBuilder;
import com.github.liaochong.myexcel.core.SaxExcelReader;
import com.github.liaochong.myexcel.utils.FileExportUtil;
import com.kenshine.myexcel.model.ArtCrowd;
import com.kenshine.myexcel.model.People;
import com.kenshine.myexcel.model.TestDO;
import org.apache.poi.ss.usermodel.Workbook;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * @author by kenshine
 * @Classname MultiTest
 * @Description 复杂类型测试
 * @Date 2024-05-03 10:52
 * @modified By：
 * @version: 1.0$
 *
 * 其他：支持图片，超链接导入导出及自定义样式
 * 详见https://github.com/liaochong/myexcel/wiki
 */
public class MultiTest {

    /**
     * 多sheet导入导出
     */
    @Test
    public void test01(){
        File excelFile = new File("input\\test04.xlsx");
        // sheet索引导入
        List<People> people1= SaxExcelReader.of(People.class).sheets(0,1).read(excelFile);
        System.out.println(people1);
        // sheet名称导入
        List<People> people2=SaxExcelReader.of(People.class).sheets("Sheet3","Sheet4").read(excelFile);
        people2.forEach(System.out::println);
    }

    /**
     * 多sheet导出
     */
    @Test
    public void test02() throws IOException {
        Workbook workbook1= DefaultExcelBuilder.of(TestDO.class).build(OutputTest.getData());
        // of(class,workbook)
        Workbook workbook2=DefaultExcelBuilder.of(ArtCrowd.class , workbook1).build(OutputTest.getDataList());
        FileExportUtil.export(workbook2, new File("output/test05.xlsx"));
    }


}
