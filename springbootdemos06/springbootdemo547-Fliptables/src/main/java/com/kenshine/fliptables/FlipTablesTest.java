package com.kenshine.fliptables;

import com.jakewharton.fliptables.FlipTable;
import com.jakewharton.fliptables.FlipTableConverters;
import com.kenshine.fliptables.enums.PersonType;
import com.kenshine.fliptables.model.Person;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * @author by kenshine
 * @Classname FlipTablesTest
 * @Description 打印测试
 * @Date 2023-12-07 10:40
 * @modified By：
 * @version: 1.0$
 */
public class FlipTablesTest {

    /**
     * ╔══════╤════════╗
     * ║ Test │ Header ║
     * ╠══════╪════════╣
     * ║ Foo  │ Bar    ║
     * ╟──────┼────────╢
     * ║ Kit  │ Kat    ║
     * ╚══════╧════════╝
     */
    @Test
    public void test01(){
        String[] headers = { "Test", "Header" };
        String[][] data = {
                { "Foo", "Bar" },
                { "Kit", "Kat" },
        };
        System.out.println(FlipTable.of(headers, data));
    }

    /**
     * ╔══════╤════════╗
     * ║ Test │ Header ║
     * ╠══════╧════════╣
     * ║ (empty)       ║
     * ╚═══════════════╝
     */
    @Test
    public void test02(){
        String[] headers = { "Test", "Header" };
        String[][] data = {};
        System.out.println(FlipTable.of(headers, data));
    }

    /**
     * 换行
     * ╔═════════╤═════════════╗
     * ║ One Two │ Four        ║
     * ║ Three   │             ║
     * ╠═════════╪═════════════╣
     * ║ Five    │ Six         ║
     * ║         │ Seven Eight ║
     * ╚═════════╧═════════════╝
     */
    @Test
    public void test03(){
        String[] headers = { "One Two\nThree", "Four" };
        String[][] data = { { "Five", "Six\nSeven Eight" } };
        System.out.println(FlipTable.of(headers, data));
    }

    /**
     * 嵌套
     * ╔═══════════════╤═══════════════╗
     * ║ Left          │ Right         ║
     * ╠═══════════════╪═══════════════╣
     * ║ ╔═════╤═════╗ │ ╔═════╤═════╗ ║
     * ║ ║ One │ Two ║ │ ║ One │ Two ║ ║
     * ║ ╠═════╪═════╣ │ ╠═════╪═════╣ ║
     * ║ ║ 1   │ 2   ║ │ ║ 1   │ 2   ║ ║
     * ║ ╚═════╧═════╝ │ ╚═════╧═════╝ ║
     * ╚═══════════════╧═══════════════╝
     */
    @Test
    public void test04(){
        String[] innerHeaders = { "One", "Two" };
        String[][] innerData = { { "1", "2" } };
        String inner = FlipTable.of(innerHeaders, innerData);
        String[] headers = { "Left", "Right" };
        String[][] data = { { inner, inner } };
        System.out.println(FlipTable.of(headers, data));
    }

    /**
     * 对象打印
     * ╔══════╤══════╗
     * ║ Name │ Nick ║
     * ╠══════╪══════╣
     * ║ Bar  │ Foo  ║
     * ╟──────┼──────╢
     * ║ Kat  │ Kit  ║
     * ╚══════╧══════╝
     */
    @Test
    public void test05(){
        List<Person> people = Arrays.asList(new Person("Foo", "Bar"), new Person("Kit", "Kat"));
        System.out.println(FlipTableConverters.fromIterable(people, Person.class));
    }

    /**
     * 从结果集获取
     * ResultSet resultSet = statement.executeQuery("SELECT first_name, last_name FROM users");
     * System.out.println(FlipTableConverters.fromResultSet(resultSet));
     */

    /**
     * 任意对象支持
     */
    @Test
    public void test06(){
        String[] headers = { "First Name", "Last Name", "Age", "Type" };
        Object[][] data = {
                { "Big", "Bird", 16, PersonType.COSTUME },
                { "Joe", "Smith", 42, PersonType.HUMAN },
                { "Oscar", "Grouchant", 8, PersonType.PUPPET }
        };
        System.out.println(FlipTableConverters.fromObjects(headers, data));
    }
}
