package mapdb;

import com.kenshine.mapdb.domain.TwoTuple;
import org.mapdb.DB;
import org.mapdb.DBMaker;
import org.mapdb.Serializer;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * @author ：kenshine
 * @date ：Created in 2021/12/28 10:06
 * @description： 性能测试
 * @modified By：
 * @version: $
 *
 * https://www.cnblogs.com/shuimutong/p/11438216.html
 */
public class MapDBTest02 {
    private final static String DEMO_KEY = "Hello";
    private final static String DEMO_VAL = "simple";

    public static void main(String[] args) {
        System.out.println("--Hello,simple----");
        fileMapMemoryMapTest();
        mapTest();
    }

    public static void mapTest() {
        int dataNum = 10000;
        List<DB> dbList = new ArrayList();
        Map<String, Map<String, Long>> testMap = new HashMap();
        Map<String, Long> dataMap = generateTestData(dataNum);
        //java原生-堆内map
        ConcurrentMap<String, Long> inHeapDbMap = new ConcurrentHashMap<>();
        testMap.put("原生map", inHeapDbMap);


        //堆外map
        DB offHeapDb = DBMaker.memoryDB().make();
        dbList.add(offHeapDb);
        ConcurrentMap offHeapDbMap = offHeapDb.hashMap("map").createOrOpen();
        testMap.put("堆外map", offHeapDbMap);

        //基于磁盘map
        DB fileDb = DBMaker.fileDB("file1.db").make();
        dbList.add(fileDb);
        ConcurrentMap<String,Long> fileDbMap = fileDb
                .hashMap("map1", Serializer.STRING, Serializer.LONG)
                .createOrOpen();
        testMap.put("基于磁盘map", fileDbMap);

        //基于磁盘-内存映射map
        DB fileMmapDb = DBMaker
                .fileDB("file2.db")
                .fileChannelEnable() //By default MapDB uses RandomAccessFile to access disk storage. Outside fast mmap files there is third option based on FileChannel. It should be faster than RandomAccessFile
                .fileMmapEnable()            // Always enable mmap
//                .fileMmapEnableIfSupported() // Only enable mmap on supported platforms，对性能影响较大
                .fileMmapPreclearDisable()   // Make mmap file faster
//                .allocateStartSize( 10 * 1024*1024*1024)  // 10GB，初始容量
//                .allocateIncrement(512 * 1024*1024)       // 512MB，每次增加容量
                .make();
        //optionally preload file content into disk cache
        fileMmapDb.getStore().fileLoad();
        dbList.add(fileMmapDb);
        ConcurrentMap<String,Long> fileMmapMap = fileMmapDb
                .hashMap("map2", Serializer.STRING, Serializer.LONG)
                .createOrOpen();
        testMap.put("基于磁盘-内存映射map", fileMmapMap);

        System.out.println("-----------put---数据量："+dataNum+"------");
        for(String mapType : testMap.keySet()) {
            putGetMapTest(mapType, testMap.get(mapType), dataMap, true);
        }
        System.out.println("-----------------------------------------\n");
        System.out.println("-----------get---数据量："+dataNum+"------");
        for(String mapType : testMap.keySet()) {
            putGetMapTest(mapType, testMap.get(mapType), dataMap, false);
        }
        for(DB db : dbList) {
            db.close();
        }
    }


    /**
     * putGet测试
     * @param map
     * @param dataMap
     * @param put
     * @return <耗时, 异常数>
     */
    public static TwoTuple<Long, Long> putGetMapTest(String mapType, Map<String, Long> map, Map<String, Long> dataMap, boolean put) {
        long useTime = 0L;
        long errorNum = 0L;
        Iterator<Map.Entry<String, Long>> entryIt = dataMap.entrySet().iterator();
        while(entryIt.hasNext()) {
            Map.Entry<String, Long> entry = entryIt.next();
            if(put) {
                long t1 = System.nanoTime();
                map.put(entry.getKey(), entry.getValue());
                useTime = System.nanoTime() - t1;
            } else {
                long t1 = System.nanoTime();
                long val = map.get(entry.getKey());
                useTime = System.nanoTime() - t1;
                if(val != entry.getValue()) {
                    errorNum++;
                }
            }
        }
        double avgUseTime = (double)useTime / dataMap.size();
        String fmtStr = "map类型：%s，总耗时：%dns，平均耗时%ens，异常数量：%d";
        System.out.println(String.format(fmtStr, mapType, useTime, avgUseTime, errorNum));
        return new TwoTuple<Long, Long>(useTime, errorNum);
    }

    /**
     * 生成测试数据
     * @param size
     * @return
     */
    public static Map<String, Long> generateTestData(int size) {
        Map<String, Long> map = new HashMap();
        int arrLength = 26;
        char[] words = new char[arrLength];
        for(int i=0; i<arrLength; i++) {
            words[i] = (char) ('a' + i);
        }
        System.out.println(words);
        String demoWord = new String(words);
        for(int i=0; i<size; i++) {
            String key = demoWord.substring(i%arrLength, i%arrLength) + i;
            long val = i;
            map.put(key, val);
        }
        return map;
    }

    /**
     * 堆外内存map
     */
    public static void offHeapMapTest1() {
        DB db = DBMaker.memoryDB().make();
        ConcurrentMap map = db.hashMap("map").createOrOpen();
        map.put(DEMO_KEY, DEMO_VAL);
        System.out.println("第1次取值，" + map.get(DEMO_KEY));
    }

    /**
     * 基于磁盘的存储
     */
    public static void fileMapTest1() {
        DB db = DBMaker.fileDB("file.db").make();
        ConcurrentMap map = db.hashMap("map").createOrOpen();

        map.put(DEMO_KEY, DEMO_VAL);
        System.out.println("第1次取值，" +map.get(DEMO_KEY));
        db.close();
        System.out.println("----------重新打开----------");
        db = DBMaker.fileDB("file.db").make();
        map = db.hashMap("map").createOrOpen();
        System.out.println("第2次取值，" +map.get(DEMO_KEY));
        db.close();
    }

    /**
     * 在64位操作系统中，开启内存映射
     * 个性化序列化
     */
    public static void fileMapMemoryMapTest() {
        DB db = DBMaker
                .fileDB("file.db")
                .fileMmapEnable()
                .make();
        ConcurrentMap<String,Long> map = db
                .hashMap("mapsl", Serializer.STRING, Serializer.LONG)
                .createOrOpen();
        long val = 51;
        map.put(DEMO_KEY, val);
        System.out.println("第1次取值，期望值：" + val + "，取到的值：" +map.get(DEMO_KEY));
        db.close();
        db = DBMaker
                .fileDB("file.db")
                .fileMmapEnable()
                .make();
        map = db.hashMap("mapsl", Serializer.STRING, Serializer.LONG)
                .createOrOpen();
        System.out.println("第2次取值，期望值：" + val + "，取到的值：" +map.get(DEMO_KEY));
        db.close();
    }
}
