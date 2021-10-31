package bilibili.collections;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;
import org.junit.Test;

import java.util.Map;
import java.util.Set;

/**
 * @author ：kenshine
 * @date ：Created in 2021/10/31 15:15
 * @description：table测试
 * @modified By：
 * @version: $
 *
 * ArrayTable
 * TreeBaseTable
 * HashBaseTable
 *  ImmutableTable
 */
public class TableTest {


    @Test
    public void testTable(){
        Table<String,String,String> table = HashBasedTable.create();
        //行key 列key
        table.put("Database","user1","kenshine");
        table.put("Database","user2","qin");

        System.out.println(table);

        //获取列-值map
        Map<String,String> map1 = table.row("Database");
        System.out.println(map1);

        //获取行-值map
        Map<String, String> map2 = table.column("user1");
        System.out.println(map2);

        //每个cell 行列-值
        Set<Table.Cell<String, String, String>> cells = table.cellSet();
        System.out.println(cells);
    }

}
