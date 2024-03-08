package com.kenshine.jsapar;

import com.kenshine.jsapar.model.Address;
import com.kenshine.jsapar.model.Employee;
import org.jsapar.Bean2TextConverter;
import org.jsapar.BeanCollection2TextConverter;
import org.jsapar.Text2BeanConverter;
import org.jsapar.Text2TextConverter;
import org.jsapar.model.LineUtils;
import org.jsapar.parse.CollectingConsumer;
import org.jsapar.schema.Schema;
import org.junit.Test;

import java.io.*;
import java.time.LocalDate;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author by kenshine
 * @Classname JsaparTest02
 * @Description
 * @Date 2024-03-08 9:17
 * @modified By：
 * @version: 1.0$
 */
public class JsaparTest02 {

    /**
     * 将CSV转换为固定宽度格式 每个格式使用固定的schema
     */
    @Test
    public void test01() throws IOException {
        try (Reader inSchemaReader = new FileReader("src/main/resources/test01/csv-schema.xml");
             Reader outSchemaReader = new FileReader("src/main/resources/test01/fw-schema.xml");
             Reader inReader = new FileReader("src/main/resources/test01/csv-unquoted.csv");
             Writer outWriter = new StringWriter()
        ) {
            // 读取schema
            Schema<?> parseSchema = Schema.ofXml(inSchemaReader);
            // 输出schema
            Schema<?> composeSchema = Schema.ofXml(outSchemaReader);
            Text2TextConverter converter = new Text2TextConverter(parseSchema, composeSchema);
            converter.convert(inReader, outWriter);
            String output = outWriter.toString();
            System.out.println(output);

            String[] lines = output.split("\\n");
        }
    }


    /**
     * csv转换为java bean Lambda表达式方式解析
     */
    @Test
    public void test02() throws IOException {
        try (Reader inSchemaReader = new FileReader("src/main/resources/test02/csv-schema.xml");
             Reader inReader = new FileReader("src/main/resources/test02/csv-employees.csv")) {
            Schema<?> parseSchema = Schema.ofXml(inSchemaReader);
            Text2BeanConverter<Employee> converter = new Text2BeanConverter<>(parseSchema);
            AtomicInteger counter = new AtomicInteger(0);
            // lambda处理每一行
            converter.convertForEach(inReader, bean -> {
                int c = counter.incrementAndGet();
                System.out.printf("Employee with count %d: %s\n", c, bean);
            });
        }
    }

    /**
     * csv转换为java bean CollectingConsumer方式解析
     */
    @Test
    public void test03() throws IOException {
        try (Reader inSchemaReader = new FileReader("src/main/resources/test02/csv-schema.xml");
             Reader inReader = new FileReader("src/main/resources/test02/csv-employees.csv")) {
            Schema<?> parseSchema = Schema.ofXml(inSchemaReader);
            Text2BeanConverter<Employee> converter = new Text2BeanConverter<>(parseSchema);
            CollectingConsumer<Employee> listener = new CollectingConsumer<>();
            // 使用CollectingConsumer解析
            converter.convertForEach(inReader, listener);
            listener.forEach(employee -> System.out.println("Employee " + employee));
        }
    }

    private Collection<Employee> makeEmployees() {
        List<Employee> people = new LinkedList<>();
        Employee testPerson1 = new Employee("Nisse Holgersson", 4, new Address("Goose street 34"), LocalDate.parse("1932-08-07"));
        people.add(testPerson1);

        Employee testPerson2 = new Employee("Jonte Lionheart", 17, new Address("Cave road 12"), LocalDate.parse("1977-03-02"));
        people.add(testPerson2);

        return people;
    }

    /**
     * java bean 转 csv 一个一个处理
     */
    @Test
    public void test04() throws IOException {
        Collection<Employee> employees = makeEmployees();

        try (Reader schemaReader = new FileReader("src/main/resources/test02/csv-schema.xml");
             StringWriter writer = new StringWriter()
        ) {
            Schema<?> composeSchema = Schema.ofXml(schemaReader);
            Bean2TextConverter<Employee> converter = new Bean2TextConverter<>(composeSchema, writer);
            for (Employee employee : employees) {
                converter.convert(employee);
            }

            String result = writer.toString();
            System.out.println("bean转csv 一个个处理");
            System.out.println(result);
            String[] lines = result.split(composeSchema.getLineSeparator());
            System.out.println(lines.length);
        }
    }

    /**
     * java bean 转 csv 集合处理
     */
    @Test
    public void test05() throws IOException {
        Collection<Employee> employees = makeEmployees();
        try (Reader schemaReader = new FileReader("src/main/resources/test02/csv-schema.xml");
             StringWriter writer = new StringWriter()
        ) {
            Schema<?> composeSchema = Schema.ofXml(schemaReader);

            BeanCollection2TextConverter<Employee> converter = new BeanCollection2TextConverter<>(composeSchema);
            converter.convert(employees, writer);

            String result = writer.toString();
            System.out.println("java bean 转 csv 集合处理");
            System.out.println(result);
            String[] lines = result.split(composeSchema.getLineSeparator());
            System.out.println(lines.length);
        }
    }

    /**
     * 转换时进行操作与过滤
     */
    @Test
    public void test06() throws IOException {
        try (Reader inSchemaReader = new FileReader("src/main/resources/test01/csv-schema.xml");
             Reader outSchemaReader = new FileReader("src/main/resources/test01/fw-schema.xml");
             Reader inReader = new FileReader("src/main/resources/test01/csv-unquoted.csv");
             Writer outWriter = new StringWriter()
        ) {

            Schema<?> parseSchema = Schema.ofXml(inSchemaReader);
            Schema<?> composeSchema = Schema.ofXml(outSchemaReader);
            Text2TextConverter converter = new Text2TextConverter(parseSchema, composeSchema);

            // 添加操作与过滤
            converter.addLineManipulator(line -> {
                final String name = LineUtils.getStringCellValue(line, "First name") + " " + LineUtils
                        .getStringCellValue(line, "Last name");

                LineUtils.setStringCellValue(line, "Name", name);
                // 返回true会输出，否则不会
                return !name.startsWith("Edgar");
            });
            converter.convert(inReader, outWriter);
            String output = outWriter.toString();
            System.out.println(output);

            String[] lines = output.split("\\n");
            System.out.println(lines[0]);
        }
    }
}
