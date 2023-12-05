package com.kenshine.jxlss;

import com.kenshine.jxlss.command.MyCommand;
import com.kenshine.jxlss.model.Employee;
import com.kenshine.jxlss.model.Experience;
import org.junit.Test;
import org.jxls.builder.xls.XlsCommentAreaBuilder;
import pres.lnk.jxlss.JxlsBuilder;
import pres.lnk.jxlss.JxlsConfig;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author by kenshine
 * @Classname JxlssTest
 * @Description jxlss使用测试
 * @Date 2023-12-05 13:01
 * @modified By：
 * @version: 1.0$
 */
public class JxlssTest {

    /**
     * 基本使用
     */
    @Test
    public void test01() throws Exception {
        JxlsConfig.config().templateRoot("src/main/resources/test01/");
        String outPath = "output/test01.xlsx";
        String imgRoot = "src/main/resources/test01/";
        System.out.println(imgRoot);
        Employee emp = getEmployee();
        List<Experience> educationList = getEducationList();
        List<Experience> workList = getWorkList();
        JxlsBuilder jxlsBuilder = JxlsBuilder
                /* -- 加载模板方式 -- */
                //使用文件流加载模板
//                .getBuilder(inputStream)
                //使用文件加载模板
//                .getBuilder(file)
                //使用路径加载模板，可以是相对路径，也可以绝对路径
                .getBuilder("employee.xlsx")

                /* -- 输出文件方式 -- */
                //指定输出的文件流
//                .out(outputStream)
                //指定输出的文件
//                .out(file)
                //指定输出的路径
                .out(outPath)

                /* 添加生成的数据 */
                .putVar("emp", emp)
                .putVar("educationList", educationList)
                .putVar("workList", workList)
                //设置图片路径的根目录
                .imageRoot(imgRoot)
                //设置如果图片缺失不终止生成
                .ignoreImageMiss(true)
                //添加自定工具类
//                .addFunction("jx", new JxlsUtil())
                .build();
        System.out.println("导出成功");
        System.out.println(jxlsBuilder.getOutFile().getAbsolutePath());
    }


    /**
     * 自定义指令注册
     */
    @Test
    public void test02(){
        XlsCommentAreaBuilder.addCommandMapping("my", MyCommand.class);
        // 使用方式
        // jx:my(attr1="expression" attr2="value" lastCell="H10")
    }

    /**
     * 动态列测试
     */
    @Test
    public void testGrid() throws Exception {
        String outPath = "output/testGrid.xlsx";

        //列名集合
        String[] headers = {"姓名", "民族", "籍贯", "住址", "联系电话"};
        //数据
        List<Employee> list = getEmployees();
        //对应数据的字段名
        String[] props = {"name", "nation", "nativePlace", "address", "phone"};
        JxlsConfig.config().templateRoot("src/main/resources/test01/");

        JxlsBuilder jxlsBuilder = JxlsBuilder
                .getBuilder("grid.xlsx")
                .out(outPath)
                .putVar("headers", Arrays.asList(headers))
                .putVar("props", props)
                .putVar("list", list)
                .build();

        System.out.println("导出成功");
        System.out.println(jxlsBuilder.getOutFile().getAbsolutePath());
    }

    private static Employee getEmployee() {
        return new Employee();
    }

    private static List<Experience> getEducationList() {
        List<Experience> list = new ArrayList<>();
        list.add(new Experience("xxx大学"));
        list.add(new Experience("xxx高中"));
        list.add(new Experience("xxx初中"));
        return list;
    }


    private static List<Experience> getWorkList() {
        List<Experience> list = new ArrayList<>();
        return list;
    }

    private static List<Employee> getEmployees() {
        List<Employee> list = new ArrayList<>();
        list.add(new Employee());
        Employee e = new Employee();
        e.setName("李四");
        e.setPicture(null);
        e.setPicture2(null);
        list.add(e);
        e = new Employee();
        e.setName("王五");
        list.add(e);
        return list;
    }
}
