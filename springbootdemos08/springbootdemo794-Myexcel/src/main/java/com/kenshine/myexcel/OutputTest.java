package com.kenshine.myexcel;

import com.github.liaochong.myexcel.core.*;
import com.github.liaochong.myexcel.core.templatehandler.FreemarkerTemplateHandler;
import com.github.liaochong.myexcel.utils.AttachmentExportUtil;
import com.github.liaochong.myexcel.utils.FileExportUtil;
import com.kenshine.myexcel.model.*;

import org.apache.poi.ss.usermodel.Workbook;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.*;
import java.util.concurrent.Executors;

/**
 * @author by kenshine
 * @Classname OutputTest
 * @Description 导出测试
 * @Date 2024-05-03 9:20
 * @modified By：
 * @version: 1.0$
 */
public class OutputTest {

    /**
     * 默认导出
     */
    @Test
    public void test01() throws IOException {
        List<ArtCrowd> dataList = OutputTest.getDataList();
        Workbook workbook = DefaultExcelBuilder.of(ArtCrowd.class)
                .build(dataList);
        FileExportUtil.export(workbook, new File("input/test01.xlsx"));
    }

    /**
     * 加密导出
     */
    @Test
    public void test02() throws Exception {
        List<ArtCrowd1> dataList = OutputTest.getDataList1();
        Workbook workbook = DefaultExcelBuilder.of(ArtCrowd1.class)
                .build(dataList);
        FileExportUtil.encryptExport(workbook, new File("input/test02.xlsx"),"123456");
    }


    /**
     * 流式导出
     */
    @Test
    public void test03() throws IOException {
        // 导出配置
        DefaultStreamExcelBuilder<ArtCrowd> streamExcelBuilder = DefaultStreamExcelBuilder
                // 如果导出地图类型数据，使用（map.class）
                .of(ArtCrowd.class)
                // 可选线程池
                .threadPool(Executors.newFixedThreadPool(10))
                // 可选容量设置
                .capacity(10_000)
                .start();
        // 添加数据
        streamExcelBuilder.asyncAppend(OutputTest::getDataList);
        // 个性化模板
//        DefaultStreamExcelBuilder<ArtCrowd> streamExcelBuilder = DefaultStreamExcelBuilder
//                .of(ArtCrowd.class)
//                .templateHandler(FreemarkerTemplateHandler.class)// Add template data, optional, suitable for extremely personalized data export
//                .start();
//
//        Map<String,Object> dataMap=new HashMap<>();
//        dataMap.put("title","测试");
//        streamExcelBuilder.append("/templates/xxx.ftl",dataMap);
        // 构建
        Workbook workbook = streamExcelBuilder.build();
        //AttachmentExportUtil.export(workbook, "艺术生信息", response);
        FileExportUtil.export(workbook, new File("output/test01.xlsx"));
        // 多文件导出
        // List<Path> paths = streamExcelBuilder.buildAsPaths();
        // zip导出方式
        // Path zip = streamExcelBuilder.buildAsZip("test");
        // AttachmentExportUtil.export(zip,"finalName.zip",response);
    }

    /**
     * 有三种类型的动态导出：
     * 动态指定标题和字段顺序；
     * 字段分组；
     * Map导出；
     *
     * 动态导出1 动态指定标题和字段顺序
     */
    @Test
    public void test04() throws IOException {
        // 标题
        List<String> titles = new ArrayList<>();
        titles.add("姓名");
        titles.add("年龄");

        // 字段显示顺序
        List<String> order = new ArrayList<>();
        order.add("name");
        order.add("age");

        // 数据显示
        List<TestDO> dataList = this.getData();
        Workbook workbook = DefaultExcelBuilder.of(TestDO.class)
                .sheetName("default example")
                .titles(titles)
                .fieldDisplayOrder(order)
                .build(dataList);
        FileExportUtil.export(workbook, new File("output/test02.xlsx"));
    }

    /**
     * 动态导出3 Map导出
     */
    @Test
    public void test05() throws IOException {
        // 标题
        Map<String, String> headerMap = new HashMap<>();
        headerMap.put("a", "测试A");
        headerMap.put("b", "测试B");
        // 数据
        List<Map> dataMapList = new ArrayList<>();
        Map<String, Object> v1 = new HashMap<>();
        v1.put("a", "数据a1");
        v1.put("b", 3);
        Map<String, Object> v2 = new HashMap<>();
        v2.put("a", "数据a2");
        v2.put("b", 5);

        dataMapList.add(v1);
        dataMapList.add(v2);

        List<String> titles = new ArrayList(headerMap.values());
        List<String> orders = new ArrayList(headerMap.keySet());
        Workbook workbook = DefaultExcelBuilder.of(Map.class)
                .sheetName("sheet1")
                .titles(titles)
                .widths(10,20)
                .fieldDisplayOrder(orders)
                .build(dataMapList);
        FileExportUtil.export(workbook, new File("output/test03.xlsx"));
    }

    /**
     * 模板导出
     */
    @Test
    public void test06() throws IOException {
        Map<String, Object> dataMap = this.getDataMap();
        try (ExcelBuilder excelBuilder = new FreemarkerExcelBuilder()) {
            Workbook workbook = excelBuilder.
                    fileTemplate("template","test.ftl")
                    //.classpathTemplate("/template/test.ftl")
                    .build(dataMap);
            FileExportUtil.export(workbook, new File("output/test04.xlsx"));
        }
    }

    /**
     * csv导出
     */
    @Test
    public void test07(){
        Csv csv= CsvBuilder.of(ArtCrowd.class).build(getDataList());
        // AttachmentExportUtil.export(csv.getFilePath(), "test.csv", response);
        csv.write(Paths.get("output\\test.csv"));
    }

    public static Map<String, Object> getDataMap() {
        Map<String, Object> dataMap = new HashMap<>();
        dataMap.put("sheetName", "freemarker_excel_example");

        List<String> titles = new ArrayList<>();
        titles.add("Category");
        titles.add("Product Name");
        titles.add("Count");
        dataMap.put("titles", titles);

        List<Product> data = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Product product = new Product();
            if (i % 2 == 0) {
                product.setCategory("蔬菜");
                product.setName("小白菜");
                product.setCount(100);
            } else {
                product.setCategory("电子产品");
                product.setName("ipad");
                product.setCount(999);
            }
            data.add(product);
        }
        dataMap.put("data", data);
        return dataMap;
    }

    public static List<TestDO> getData(){
        TestDO testDO = new TestDO();
        testDO.setName("张三");
        TestDO testDO1 = new TestDO();
        testDO1.setName("李四");

        TestDO testDO2 = new TestDO();
        testDO2.setName("王五");
        testDO2.setAge(15);
        TestDO testDO3 = new TestDO();
        testDO3.setName("陈六");
        testDO3.setAge(25);

        List<TestDO> dataList = new ArrayList<>();
        dataList.add(testDO);
        dataList.add(testDO1);
        dataList.add(testDO2);
        dataList.add(testDO3);

        return dataList;
    }


    public static List<ArtCrowd> getDataList() {
        List<ArtCrowd> dataList = new ArrayList<>(1000);
        for (int i = 0; i < 1000; i++) {
            ArtCrowd artCrowd = new ArtCrowd();
            artCrowd.setName("kenshine"+i);
            artCrowd.setAge(18);
            artCrowd.setBirthday(new Date());
            artCrowd.setDance(true);
            dataList.add(artCrowd);
        }
        return dataList;
    }

    public static List<ArtCrowd1> getDataList1() {
        List<ArtCrowd1> dataList = new ArrayList<>(1000);
        for (int i = 0; i < 1000; i++) {
            ArtCrowd1 artCrowd = new ArtCrowd1();
            artCrowd.setName("李四");
            artCrowd.setAge(18);
            artCrowd.setGender("Woman");
            artCrowd.setPaintingLevel("一级证书");
            artCrowd.setDance(true);
            artCrowd.setAssessmentTime(LocalDateTime.now());
            artCrowd.setHobby("钓鱼");
            dataList.add(artCrowd);
        }
        return dataList;
    }


}
