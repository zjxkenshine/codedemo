package easy.dao;

import easy.data.ConverterData;
import easy.data.DemoData;
import easy.data.IndexOrNameData;

import java.util.List;

/**
 * @author kenshine
 * @create 2020-10-30 8:42
 **/
public class DemoDAO {

    public void save(List<DemoData> list) {
        // 如果是mybatis,尽量别直接调用多次insert,自己写一个mapper里面新增一个方法batchInsert,所有数据一次性插入
        System.out.println(list);
    }

    public void save2(List<IndexOrNameData> list) {
        // 如果是mybatis,尽量别直接调用多次insert,自己写一个mapper里面新增一个方法batchInsert,所有数据一次性插入
        System.out.println(list);
    }

    public void save3(List<ConverterData> list) {
        // 如果是mybatis,尽量别直接调用多次insert,自己写一个mapper里面新增一个方法batchInsert,所有数据一次性插入
        System.out.println(list);
    }

}
