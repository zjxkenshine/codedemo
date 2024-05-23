package com.kenshine.poiji;

import com.kenshine.poiji.cast.MyCasting;
import com.kenshine.poiji.model.*;
import com.poiji.bind.Poiji;
import com.poiji.exception.PoijiExcelType;
import com.poiji.option.PoijiOptions;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.List;

/**
 * @author by kenshine
 * @Classname PoijiTest
 * @Description poiji测试
 * @Date 2024-05-23 9:50
 * @modified By：
 * @version: 1.0$
 */
public class PoijiTest {

    /**
     * 从excel读取数据
     * 列表数据默认使用,作为分隔符
     */
    @Test
    public void test01() throws FileNotFoundException {
        PoijiOptions options = PoijiOptions.PoijiOptionsBuilder.settings()
                .addListDelimiter(";")
                .build();
        List<Employee> employees = Poiji.fromExcel(new File("file\\test01.xlsx"), Employee.class, options);
        // 或者可以这样写
        InputStream stream = new FileInputStream("file\\test01.xlsx");
        List<Employee> employees1 = Poiji.fromExcel(stream, PoijiExcelType.XLSX, Employee.class, options);

        System.out.println(employees.size());
        System.out.println(employees);
        System.out.println(employees1);
    }

    /**
     * 默认情况下，Poiji会忽略excel数据的标题行。如果要忽略第一行数据，则需要使用PoijiOptions。
     */
    @Test
    public void test02(){
        // 排除第一行数据
        PoijiOptions options = PoijiOptions.PoijiOptionsBuilder.settings(1).build();
        List<Employee> employees = Poiji.fromExcel(new File("file\\test01.xlsx"), Employee.class, options);
        System.out.println(employees.size());
        System.out.println(employees);
    }

    /**
     * 选择sheet，默认第一个
     */
    @Test
    public void test03(){
        PoijiOptions options = PoijiOptions.PoijiOptionsBuilder.settings()
                .sheetIndex(0)
                .build();
        List<Employee> employees = Poiji.fromExcel(new File("file\\test01.xlsx"), Employee.class, options);
        System.out.println(employees.size());
        System.out.println(employees);
    }

    /**
     * 返回null而不是默认值
     * 类型为java.util。Date、Float、Double、Integer、Long或String将具有空值
     */
    @Test
    public void test04(){
        PoijiOptions options = PoijiOptions.PoijiOptionsBuilder.settings()
                .preferNullOverDefault(true)
                .build();
        List<Employee> employees = Poiji.fromExcel(new File("file\\test01.xlsx"), Employee.class, options);
        System.out.println(employees.size());
        System.out.println(employees);
    }

    /**
     * 读取加密文件
     */
    @Test
    public void test05(){
        PoijiOptions options = PoijiOptions.PoijiOptionsBuilder.settings()
                .password("123456")
                .build();
        List<Employee> employees = Poiji.fromExcel(new File("file\\test02.xlsx"), Employee.class, options);
        System.out.println(employees);
    }

    /**
     * 表头名称读取
     */
    @Test
    public void test06(){
        List<Person> people = Poiji.fromExcel(new File("file\\test03.xlsx"), Person.class);
        System.out.println(people.size());
        Person person = people.get(0);
        System.out.println(person);
    }


    /**
     * 派生类
     */
    @Test
    public void test07(){
        List<Car> cars = Poiji.fromExcel(new File("file\\test04.xlsx"), Car.class);
        System.out.println(cars.size());
        System.out.println(cars);
    }

    /**
     * 使用ExcelCellsJoinedByName，我们可以读取名称符合相同正则表达式的列
     * 多列映射到一个字段
     */
    @Test
    public void test08(){
        List<Album> albums = Poiji.fromExcel(new File("file\\test05.xlsx"), Album.class);
        System.out.println(albums.size());
        Album album1 = albums.get(0);
        Album album2 = albums.get(1);
        System.out.println(album1);
        System.out.println(album2);
    }

    /**
     * 复杂表格
     */
    @Test
    public void test09(){
        PoijiOptions options = PoijiOptions.PoijiOptionsBuilder.settings().headerCount(2).build();
        List<PersonCreditInfo> actualPersonalCredits = Poiji.fromExcel(new File("file\\test06.xlsx"), PersonCreditInfo.class, options);
        PersonCreditInfo personCreditInfo1 = actualPersonalCredits.get(0);
        PersonCreditInfo.PersonInfo expectedPerson1 = personCreditInfo1.getPersonInfo();
        PersonCreditInfo.CardInfo expectedCard1 = personCreditInfo1.getCardInfo();
        System.out.println(actualPersonalCredits);
        System.out.println(personCreditInfo1);
        System.out.println(expectedCard1);
    }

    /**
     * consumer接口支持
     */
    @Test
    public void test10(){
        PoijiOptions options = PoijiOptions.PoijiOptionsBuilder.settings().sheetIndex(0).build();
        Poiji.fromExcel(new File("file\\test07.xlsx"), Calculation.class, options, System.out::println);
    }

    /**
     * 自定义转换器
     */
    @Test
    public void test11(){
        PoijiOptions options = PoijiOptions.PoijiOptionsBuilder.settings()
                .withCasting(new MyCasting())
                .build();
        List<Person1> people = Poiji.fromExcel(new File("file\\test08.xlsx"), Person1.class, options);
        System.out.println(people);
    }

    /**
     * 未知字段处理
     */
    @Test
    public void test12(){
        PoijiOptions options = PoijiOptions.PoijiOptionsBuilder.settings().build();
        List<MusicTrack> people = Poiji.fromExcel(new File("file\\test09.xlsx"), MusicTrack.class, options);
        System.out.println(people);
    }
}
