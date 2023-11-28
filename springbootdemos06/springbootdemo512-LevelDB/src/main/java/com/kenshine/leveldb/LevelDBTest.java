package com.kenshine.leveldb;

import org.fusesource.leveldbjni.JniDBFactory;
import org.iq80.leveldb.*;

import static org.fusesource.leveldbjni.JniDBFactory.*;

import org.junit.Test;

import java.io.File;
import java.io.IOException;

/**
 * @author by kenshine
 * @Classname LevelDBTest
 * @Description LevelDB测试
 * @Date 2023-11-28 16:33
 * @modified By：
 * @version: 1.0$
 */
public class LevelDBTest {

    /**
     * 添加/删除测试
     */
    @Test
    public void test01() throws IOException {
        Options options = new Options();
        options.createIfMissing(true);
        DB db = factory.open(new File("F:\\leveldb\\test"), options);
        try {
            // 执行db操作
            db.put(bytes("Tampa"), bytes("rocks"));
            String value = asString(db.get(bytes("Tampa")));
            System.out.println(value);
            db.delete(bytes("Tampa"));
        } finally {
            db.close();
        }
    }

    /**
     * WriteBatch 批量写
     */
    @Test
    public void test02() throws IOException {
        Options options = new Options();
        options.createIfMissing(true);
        DB db = factory.open(new File("F:\\leveldb\\test"), options);
        WriteBatch batch = db.createWriteBatch();
        try {
            batch.delete(bytes("Denver"));
            batch.put(bytes("Tampa"), bytes("green"));
            batch.put(bytes("London"), bytes("red"));
            db.write(batch);
        } finally {
            batch.close();
        }
    }

    /**
     * DBIterator 遍历
     */
    @Test
    public void test03() throws IOException {
        Options options = new Options();
        options.createIfMissing(true);
        DB db = factory.open(new File("F:\\leveldb\\test"), options);
        DBIterator iterator = db.iterator();
        try {
            for (iterator.seekToFirst(); iterator.hasNext(); iterator.next()) {
                String key = asString(iterator.peekNext().getKey());
                String value = asString(iterator.peekNext().getValue());
                System.out.println(key + " = " + value);
            }
        } finally {
            iterator.close();
        }
    }

    /**
     *  getSnapshot 快照
     */
    @Test
    public void test04() throws IOException {
        Options options = new Options();
        options.createIfMissing(true);
        DB db = factory.open(new File("F:\\leveldb\\test"), options);
        // 快照
        ReadOptions ro = new ReadOptions();
        ro.snapshot(db.getSnapshot());
        try {
            // 遍历快照
            DBIterator iterator = db.iterator(ro);
            for (iterator.seekToFirst(); iterator.hasNext(); iterator.next()) {
                String key = asString(iterator.peekNext().getKey());
                String value = asString(iterator.peekNext().getValue());
                System.out.println(key + " = " + value);
            }
            // 获取快照值
            String s =asString(db.get(bytes("Tampa"), ro));
            System.out.println(s);
        } finally {
            ro.snapshot().close();
        }
    }

    /**
     * 自定义比较器
     */
    @Test
    public void test05() throws IOException {
        DBComparator comparator = new DBComparator(){
            @Override
            public int compare(byte[] key1, byte[] key2) {
                return new String(key1).compareTo(new String(key2));
            }
            @Override
            public String name() {
                return "test";
            }
            @Override
            public byte[] findShortestSeparator(byte[] start, byte[] limit) {
                return start;
            }
            @Override
            public byte[] findShortSuccessor(byte[] key) {
                return key;
            }
        };
        Options options = new Options();
        options.comparator(comparator);
        DB db = factory.open(new File("F:\\leveldb\\test"), options);
    }

    /**
     * 禁用压缩
     */
    @Test
    public void test06() throws IOException {
        Options options = new Options();
        options.compressionType(CompressionType.NONE);
        DB db = factory.open(new File("F:\\leveldb\\test"), options);
        db.close();
    }

    /**
     * 设置缓存最大值
     */
    @Test
    public void test07() throws IOException {
        Options options = new Options();
        // 100MB cache
        options.cacheSize(100 * 1048576);
        DB db = factory.open(new File("F:\\leveldb\\test"), options);
        // 获取近似尺寸
        long[] sizes = db.getApproximateSizes(new Range(bytes("a"), bytes("k")), new Range(bytes("k"), bytes("z")));
        System.out.println("Size: "+sizes[0]+", "+sizes[1]);
        db.close();
    }

    /**
     * getProperty 获取状态
     */
    @Test
    public void test08() throws IOException {
        Options options = new Options();
        options.createIfMissing(true);
        DB db = factory.open(new File("F:\\leveldb\\test"), options);
        String stats = db.getProperty("leveldb.stats");
        System.out.println(stats);
        db.close();
    }

    /**
     * 设置日志实现
     */
    @Test
    public void test09() throws IOException {
        Logger logger = message -> System.out.println("自定义"+message);
        Options options = new Options();
        options.logger(logger);
        DB db = factory.open(new File("F:\\leveldb\\test"), options);
        db.close();
    }

    /**
     * 删除数据库
     */
    @Test
    public void test10() throws IOException {
        Options options = new Options();
        factory.destroy(new File("F:\\leveldb\\test"), options);
    }

    /**
     * 内存池
     */
    @Test
    public void test11(){
        JniDBFactory.pushMemoryPool(1024 * 512);
        try {
            // db操作
        } finally {
            JniDBFactory.popMemoryPool();
        }
    }

    /**
     * 修复数据库
     */
    @Test
    public void test12() throws IOException {
        Options options = new Options();
        factory.repair(new File("F:\\leveldb\\test"), options);
    }

}
