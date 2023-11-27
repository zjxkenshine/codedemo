package com.kenshine.jxls;

import com.kenshine.jxls.listener.SimpleAreaListener;
import com.kenshine.jxls.model.Department;
import com.kenshine.jxls.model.Employee;
import org.junit.Test;
import org.jxls.area.XlsArea;
import org.jxls.command.*;
import org.jxls.common.AreaRef;
import org.jxls.common.CellRef;
import org.jxls.common.Context;
import org.jxls.transform.Transformer;
import org.jxls.transform.poi.PoiTransformer;
import org.jxls.util.JxlsHelper;
import org.jxls.util.TransformerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

/**
 * @author by kenshine
 * @Classname Test01
 * @Description 测试导出
 * @Date 2023-11-27 8:53
 * @modified By：
 * @version: 1.0$
 */
public class JxlsTest {
    Logger logger = LoggerFactory.getLogger(JxlsTest.class);

    /**
     * 基础生成
     */
    @Test
    public void test01(){
        List<Employee> employees = generate();
        try(InputStream is = new FileInputStream("template/test01.xls")) {
            try (OutputStream os = new FileOutputStream("output/test01.xls")) {
                Context context = new Context();
                context.putVar("employees", employees);
                JxlsHelper.getInstance().processTemplate(is, os, context);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 公式输出
     */
    @Test
    public void test02(){
        List<Employee> employees = generate();
        try(InputStream is = new FileInputStream("template/test02.xls")) {
            try (OutputStream os = new FileOutputStream("output/test02.xls")) {
                Context context = new Context();
                context.putVar("employees", employees);
                // 输出到result工作簿，A1开始
                JxlsHelper.getInstance().processTemplateAtCell(is, os, context, "Result!A1");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 监听器,复杂表格
     */
    @Test
    public void test03(){
        List<Department> departments = createDepartments();
        logger.info("Opening input stream");
        try(InputStream is = new FileInputStream("template/test03.xls")) {
            try (OutputStream os = new FileOutputStream("output/test03.xls")) {
                Transformer transformer = TransformerFactory.createTransformer(is, os);
                System.out.println("Creating area");
                XlsArea xlsArea = new XlsArea("Template!A1:G15", transformer);
                XlsArea departmentArea = new XlsArea("Template!A2:G12", transformer);
                EachCommand departmentEachCommand = new EachCommand("department", "departments", departmentArea);
                XlsArea employeeArea = new XlsArea("Template!A9:F9", transformer);
                XlsArea ifArea = new XlsArea("Template!A18:F18", transformer);
                XlsArea elseArea = new XlsArea("Template!A9:F9", transformer);
                IfCommand ifCommand = new IfCommand("employee.payment <= 2000",
                        ifArea,
                        elseArea);
                ifArea.addAreaListener(new SimpleAreaListener(ifArea));
                elseArea.addAreaListener(new SimpleAreaListener(elseArea));
                employeeArea.addCommand(new AreaRef("Template!A9:F9"), ifCommand);
                Command employeeEachCommand = new EachCommand("employee", "department.staff", employeeArea);
                departmentArea.addCommand(new AreaRef("Template!A9:F9"), employeeEachCommand);
                xlsArea.addCommand(new AreaRef("Template!A2:F12"), departmentEachCommand);
                Context context = new Context();
                context.putVar("departments", departments);
                logger.info("Applying at cell " + new CellRef("Down!A1"));
                xlsArea.applyAt(new CellRef("Down!A1"), context);
                xlsArea.processFormulas();
                logger.info("Setting EachCommand direction to Right");
                departmentEachCommand.setDirection(EachCommand.Direction.RIGHT);
                logger.info("Applying at cell " + new CellRef("Right!A1"));
                xlsArea.reset();
                xlsArea.applyAt(new CellRef("Right!A1"), context);
                xlsArea.processFormulas();
                logger.info("Complete");
                transformer.write();
                logger.info("written to file");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 输出到多个工作表
     */
    @Test
    public void test04(){
        List<Department> departments = createDepartments();
        try (InputStream is = new FileInputStream("template/test04.xls")) {
            try (OutputStream os = new FileOutputStream("output/test04.xls")) {
                Context context = PoiTransformer.createInitialContext();
                context.putVar("departments", departments);
                context.putVar("sheetNames", Arrays.asList(
                        departments.get(0).getName(),
                        departments.get(1).getName()));
                JxlsHelper.getInstance().processTemplate(is, os, context);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 输出到多个工作表
     */
    @Test
    public void test05(){
        List<Department> departments = createDepartments();
        logger.info("Opening input stream");
        try(InputStream is = new FileInputStream("template/test05.xls")) {
            try (OutputStream os = new FileOutputStream("output/test05.xls")) {
                Transformer transformer = TransformerFactory.createTransformer(is, os);
                System.out.println("Creating area");
                XlsArea xlsArea = new XlsArea("Template!A1:G15", transformer);
                XlsArea departmentArea = new XlsArea("Template!A2:G12", transformer);
                EachCommand departmentEachCommand = new EachCommand("department", "departments", departmentArea, new SheetNameGenerator(Arrays.asList("sheet1","sheet2"),new CellRef("A1")));
                XlsArea employeeArea = new XlsArea("Template!A9:F9", transformer);
                XlsArea ifArea = new XlsArea("Template!A18:F18", transformer);
                IfCommand ifCommand = new IfCommand("employee.payment <= 2000",
                        ifArea,
                        new XlsArea("Template!A9:F9", transformer));
                employeeArea.addCommand(new AreaRef("Template!A9:F9"), ifCommand);
                Command employeeEachCommand = new EachCommand("employee", "department.staff", employeeArea);
                departmentArea.addCommand(new AreaRef("Template!A9:F9"), employeeEachCommand);
                xlsArea.addCommand(new AreaRef("Template!A2:F12"), departmentEachCommand);
                Context context = new Context();
                context.putVar("departments", departments);
                logger.info("Applying at cell Sheet!A1");
                xlsArea.applyAt(new CellRef("Sheet!A1"), context);
                xlsArea.processFormulas();
                logger.info("Complete");
                transformer.write();
                logger.info("written to file");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 分组
     */
    @Test
    public void test06() throws ParseException {
        List<Employee> employees = generate2();
        try(InputStream is = new FileInputStream("template/test06.xlsx")) {
            try (OutputStream os = new FileOutputStream("output/test06.xlsx")) {
                Context context = new Context();
                context.putVar("employees", employees);
                JxlsHelper.getInstance().processTemplate(is, os, context);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private List<Department> createDepartments() {
        Department d1= new Department().setName("st").setChief(new Employee().setName("lj").setAge(40).setPayment(100.00).setBonus(100.00)).setStaff(generate()).setLink("www.st.com");
        Department d2 = new Department().setName("hf").setChief(new Employee().setName("ss").setAge(38).setPayment(108.00).setBonus(200.00)).setStaff(generate()).setLink("www.hf.org");
        return Arrays.asList(d1,d2);
    }

    /**
     * 生成数据
     */
    private static List<Employee> generate() {
        ArrayList<Employee> employeeList = new ArrayList<>();
        employeeList.add(new Employee().setAge(18).setName("kenshine").setPayment(29.99).setBonus(0.00));
        employeeList.add(new Employee().setAge(21).setName("qin").setPayment(9.99).setBonus(3.00));
        employeeList.add(new Employee().setAge(10).setName("tt").setPayment(2.68).setBonus(0.39));
        return employeeList;
    }

    public static List<Employee> generate2() throws ParseException {
        List<Employee> employees = new ArrayList<>();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MMM-dd", Locale.US);
        employees.add( new Employee("Elsa", dateFormat.parse("1970-Jul-10"), 1500D, 0.15) );
        employees.add( new Employee("Oleg", dateFormat.parse("1973-Apr-30"), 2300D, 0.25) );
        employees.add( new Employee("John", dateFormat.parse("1970-Jul-10"), 3500D, 0.10) );
        employees.add( new Employee("Neil", dateFormat.parse("1975-Oct-05"), 2500D, 0.00) );
        employees.add( new Employee("Maria", dateFormat.parse("1978-Jan-07"), 1700D, 0.15) );
        employees.add( new Employee("John", dateFormat.parse("1969-May-30"), 2800D, 0.20) );
        employees.add( new Employee("Oleg", dateFormat.parse("1988-Apr-30"), 1500D, 0.15) );
        employees.add( new Employee("Maria", dateFormat.parse("1970-Jul-10"), 3000D, 0.10) );
        employees.add( new Employee("John", dateFormat.parse("1973-Apr-30"), 1000D, 0.05) );
        return employees;
    }

}
