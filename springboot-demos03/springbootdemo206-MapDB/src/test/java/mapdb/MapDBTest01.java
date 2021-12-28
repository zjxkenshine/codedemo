package mapdb;

import org.junit.Test;
import org.mapdb.DB;
import org.mapdb.DBMaker;
import org.mapdb.Serializer;
import org.mapdb.SortedTableMap;
import org.mapdb.volume.MappedFileVol;
import org.mapdb.volume.Volume;

import java.io.File;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ConcurrentNavigableMap;

/**
 * @author ：kenshine
 * @date ：Created in 2021/12/28 8:36
 * @description：测试1
 * @modified By：
 * @version: $
 */
public class MapDBTest01 {

    /**
     * 1.文件存储
     */
    @Test
    public void test01(){
        DB db = DBMaker
                //存储在file.db文件中
                .fileDB("file.db")
                //64 位操作系统，内存映射文件
                .fileMmapEnable()
                .make();
        //使用堆外存储的Map，不受GC影响
        ConcurrentMap map = db.hashMap("map")
                //默认情况下，MapDB 使用通用序列化，它可以序列化任何数据类型。使用专门的序列化程序速度更快
                .valueSerializer(Serializer.STRING)
                .keySerializer(Serializer.STRING)
                .createOrOpen();

        map.put("name", "kenshine");

        //关闭以保护内存文件
        db.close();
    }

    /**
     * 2.事务
     */
    @Test
    public void test02(){
        DB db = DBMaker
                //存储在file.db文件中 不指定则放在堆外存储
                .fileDB("file.db")
                //64 位操作系统，内存映射文件
                .fileMmapEnable()
                //开启事务
                .transactionEnable()
                //JVM关闭时关闭db
                .closeOnJvmShutdown()
                .make();

        ConcurrentNavigableMap<Integer,String> map = db
                .treeMap("test02", Serializer.INTEGER, Serializer.STRING)
                .createOrOpen();

        map.put(1,"one");
        map.put(2,"two");
        //提交
        db.commit();
        System.out.println(map.keySet());

        map.put(3,"three");
        //回滚
        db.rollback();
        System.out.println(map.keySet());

        db.close();
    }

    /**
     * 3.创建 SortedTableMap 不依赖DBMaker
     */
    @Test
    public void test03(){
        //创建一个内存映射 Volume
        Volume volume = MappedFileVol.FACTORY.makeVolume("file.db", false);

        //打开消费者填充SortedTableMap
        SortedTableMap.Sink<Integer,String> sink =
                SortedTableMap.create(
                        volume,
                        Serializer.INTEGER,
                        Serializer.STRING
                ).createFromSink();

        //填充数据
        for(int key=0; key<1000; key++){
            sink.put(key, "value"+key);
        }

        //创建Map
        SortedTableMap<Integer, String> map = sink.create();
        System.out.println(map.size());
    }

    /**
     * 4.打开SortedTableMap
     */
    @Test
    public void test04(){
        Volume volume = MappedFileVol.FACTORY.makeVolume("file.db", true);

        SortedTableMap<Integer,String> map =
                SortedTableMap.open(
                        volume,
                        Serializer.INTEGER,
                        Serializer.STRING
                );
        System.out.println(map.size());
    }

}
