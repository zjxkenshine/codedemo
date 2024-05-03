package com.kenshine.myexcel;

import com.github.liaochong.myexcel.core.DefaultExcelReader;
import com.github.liaochong.myexcel.core.SaxExcelReader;
import com.kenshine.myexcel.model.ArtCrowd;
import com.kenshine.myexcel.model.Grade;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.nio.file.Files;
import java.util.List;

/**
 * @author by kenshine
 * @Classname InputTest
 * @Description 导入测试
 * @Date 2024-05-03 9:04
 * @modified By：
 * @version: 1.0$
 */
public class InputTest {

    /**
     * 一般导入，方式一 全部读取后处理
     */
    @Test
    public void test01() throws FileNotFoundException {
        // 方式一：全部读取后处理
        List<ArtCrowd> result = DefaultExcelReader.of(ArtCrowd.class)
                // 0代表第一个，如果为0，可省略该操作，也可sheet("名称")读取
                .sheet(0)
                // 如无需过滤，可省略该操作，0代表第一行
                .rowFilter(row -> row.getRowNum() > 0)
                // bean过滤
                .beanFilter(ArtCrowd::isDance)
                // 在开始读取sheet前执行指定操作
                .startSheet(sheet->System.out.println(sheet.getSheetName()))
                // 可接收inputStream
                .read(new FileInputStream("input\\test01.xlsx"));
        System.out.println(result);
    }

    /**
     * 一般导入，方式二 读取一行处理一行，可自行决定终止条件
     */
    @Test
    public void test02() throws FileNotFoundException {
        // 方式二：读取一行处理一行，可自行决定终止条件
        // readThen有两种重写接口，返回Boolean型接口允许在返回False情况下直接终止读取
        DefaultExcelReader.of(ArtCrowd.class)
                // 0代表第一个，如果为0，可省略该操作，也可sheet("名称")读取
                .sheet(0)
                // 如无需过滤，可省略该操作，0代表第一行
                .rowFilter(row -> row.getRowNum() > 0)
                // bean过滤
                .beanFilter(ArtCrowd::isDance)
                // 可接收inputStream
                .readThen(new FileInputStream("input\\test01.xlsx"),artCrowd -> {System.out.println(artCrowd.getName());});
    }

    /**
     * SAX导入（支持csv文件导入）
     * 方式一：全部读取后处理，SAX模式，避免OOM，建议大量数据使用
     */
    @Test
    public void test03() throws FileNotFoundException {
        List<ArtCrowd> result = SaxExcelReader.of(ArtCrowd.class)
                // 0代表第一个，如果为0，可省略该操作，也可sheet("名称")读取，.csv文件无效
                .sheet(0)
                // 如无需过滤，可省略该操作，0代表第一行
                .rowFilter(row -> row.getRowNum() > 0)
                // 仅.csv文件有效，设置当前文件的编码，可选，默认为UTF-8
                .csvCharset("GBK")
                // 仅.csv文件有效，设置当前文件分割符，可选，默认为英文逗号-,
                .csvDelimiter(';')
                // 是否忽略空行，可选，默认不忽略
                .ignoreBlankRow()
                // 是否遇到空行则停止读取，可选，默认为否
                .stopReadingOnBlankRow()
                // 识别合并单元格，默认不识别
                .detectedMerge()
                // 可选，bean过滤
                .beanFilter(ArtCrowd::isDance)
                // 可接收inputStream
                .read(new FileInputStream("input\\test01.xlsx"));
    }

    /**
     * SAX导入（支持csv文件导入）
     * 方式二：读取一行处理一行，可自行决定终止条件
     */
    @Test
    public void test04() throws FileNotFoundException {
        SaxExcelReader.of(ArtCrowd.class)
                // 0代表第一个，如果为0，可省略该操作，也可sheet("名称")读取，.csv文件无效
                .sheet(0)
                // 如无需过滤，可省略该操作，0代表第一行
                .rowFilter(row -> row.getRowNum() > 0)
                // 仅.csv文件有效，设置当前文件的编码，可选，默认为UTF-8
                .csvCharset("GBK")
                // 仅.csv文件有效，设置当前文件分割符，可选，默认为英文逗号-,
                .csvDelimiter(';')
                // 是否忽略空行，可选，默认不忽略
                .ignoreBlankRow()
                // 是否遇到空行则停止读取，可选，默认为否
                .stopReadingOnBlankRow()
                // 识别合并单元格，默认不识别
                .detectedMerge()
                // 可选，bean过滤
                .beanFilter(ArtCrowd::isDance)
                // 可接收inputStream
                .readThen(new FileInputStream("input\\test01.xlsx") ,artCrowd -> {System.out.println(artCrowd.getName());});
    }

    /**
     * 一对多导入
     */
    @Test
    public void test05() throws FileNotFoundException {
        List<Grade> multiParents = SaxExcelReader.of(Grade.class)
                // 取消表头
                .rowFilter(row -> row.getRowNum() > 0)
                // 必须要调用识别合并单元格方法，否则无效
                .detectedMerge()
                .read(new FileInputStream("input\\test03.xlsx"));
        multiParents.forEach(System.out::println);
    }


}
