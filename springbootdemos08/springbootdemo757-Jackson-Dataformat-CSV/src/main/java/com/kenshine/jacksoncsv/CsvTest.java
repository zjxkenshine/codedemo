package com.kenshine.jacksoncsv;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.databind.SequenceWriter;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author by kenshine
 * @Classname CsvTest
 * @Description csv测试
 * @Date 2024-03-27 10:27
 * @modified By：
 * @version: 1.0$
 */
public class CsvTest {

    /**
     * java对象转CSV
     */
    @Test
    public void test01() throws IOException {
        CsvMapper csvMapper = new CsvMapper();
        // 设置日期格式
        csvMapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
        CsvSchema csvSchema = csvMapper.schemaFor(CostDetail.class).withHeader();

        CostDetail costDetail = new CostDetail();
        costDetail.setAmount(BigDecimal.valueOf(12.55D));
        costDetail.setApplyId(11L);
        costDetail.setCostCenterId(66L);
        costDetail.setCreatedTime(new Date());
        costDetail.setStatus(1L);
        costDetail.setTypeId(77L);
        costDetail.setTypeName("v");
        costDetail.setUserId(88L);
        System.out.println(csvSchema);
        csvSchema.forEach(t -> System.out.println(t.getName()));
        try (SequenceWriter writer = csvMapper.writer(csvSchema).writeValues(new File("csv\\test.csv"));) {
            writer.write(costDetail);
        }
    }

    /**
     * 读取csv文件
     */
    @Test
    public void test02(){
        //CsvSchema schema = CsvSchema.emptySchema().withHeader();
        CsvMapper csvMapper = new CsvMapper();
        // 设置日期格式
        csvMapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
        CsvSchema csvSchema = csvMapper.schemaFor(CostDetail.class).withHeader();

        System.out.println("read from file");
        try (InputStream inputStream = new FileInputStream("csv\\test.csv") ) {

            MappingIterator<CostDetail> values = csvMapper.readerFor(CostDetail.class).with(csvSchema).readValues(inputStream);
            values.forEachRemaining(System.out::println);
        } catch (Exception e) {
           e.printStackTrace();
        }
    }
}
