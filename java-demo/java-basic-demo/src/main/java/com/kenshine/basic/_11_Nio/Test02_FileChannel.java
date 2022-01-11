package com.kenshine.basic._11_Nio;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * @author ：kenshine
 * @date ：Created in 2022/1/11 21:21
 * @description：
 * @modified By：
 * @version: $
 * 1.FileChannel 非直接内存实现文件复制
 * 2.直接内存映射实现文件复制
 * 3.通道之间数据传输
 * 4.分散(Scatter)与聚集(Gather)
 * 分散读取：将通道中的数据分散到多个缓冲区中
 * 聚集写入：将多个缓冲区中的数据聚集到通道中
 */
public class Test02_FileChannel {

    /**
     * FileChannel实现文件复制
     */
    @Test
    public void test01() throws IOException {
        FileInputStream fis=new FileInputStream("1.jpg");
        FileOutputStream fos=new FileOutputStream("2.jpg");

        //获取通道
        FileChannel inChannel=fis.getChannel();
        FileChannel outChannel=fos.getChannel();

        //分配指定大小的缓冲区
        ByteBuffer buf= ByteBuffer.allocate(1024);

        //将通道中的数据存入缓冲区中
        while(inChannel.read(buf)!=-1) {
            buf.flip();//切换为写数据模式
            //将缓冲数据写入通道
            outChannel.write(buf);
            buf.clear();	//清空缓冲区
        }
        //关闭通道和数据流
        outChannel.close();
        inChannel.close();
        fos.close();
        fis.close();
    }

    /**
     * 使用直接缓冲区（内存映射文件）完成文件复制
     *
     * 复制速度变快，但是有个问题：
     *    - 复制很快，但是程序可能很久才会结束
     *    - 效率高，但是不太稳定，看GC什么时候回收资源
     *    - 最好分配给易受缓冲区影响的缓冲区
     *    - jdk1.9之后可以强制回收：`cleaner`
     */
    @Test
    public void test02() throws IOException {
        FileChannel inChannel=FileChannel.open(Paths.get("1.jpg"), StandardOpenOption.READ);
        FileChannel outChannel=FileChannel.open(Paths.get("2.jpg"),StandardOpenOption.WRITE,StandardOpenOption.CREATE,StandardOpenOption.READ);
        //内存映射文件
        MappedByteBuffer inMappedBuf=inChannel.map(FileChannel.MapMode.READ_ONLY,0,inChannel.size());
        MappedByteBuffer outMappedBuf=outChannel.map(FileChannel.MapMode.READ_WRITE,0,inChannel.size());
        //直接对缓冲区进行数据读写(不用经过通道)
        byte[] dst=new byte[inMappedBuf.limit()];
        inMappedBuf.get(dst);
        outMappedBuf.put(dst);
        //关闭
        inChannel.close();
        outChannel.close();
    }

    /**
     * 3.通道间数据传输
     */
    @Test
    public void test03() throws IOException {
        FileChannel inChannel=FileChannel.open(Paths.get("1.jpg"), StandardOpenOption.READ);
        FileChannel outChannel=FileChannel.open(Paths.get("2.jpg"), StandardOpenOption.WRITE,StandardOpenOption.READ);
        //方式一:transferTo
        //inChannel.transferTo(0, inChannel.size(), outChannel);
        //方式二:transferFrom
        outChannel.transferFrom(inChannel, 0, inChannel.size());
        inChannel.close();
        outChannel.close();
    }

    /**
     * 4. 分散读取 与 聚集写入
     */
    @Test
    public void test04() throws IOException {
        RandomAccessFile ref1=new RandomAccessFile("1.jpg","rw");
        //获取通道
        FileChannel channel1=ref1.getChannel();
        //分配指定大小的缓冲区
        ByteBuffer buf1=ByteBuffer.allocate(100);
        ByteBuffer buf2=ByteBuffer.allocate(1024);
        //分散读取
        ByteBuffer[] bufs= {buf1,buf2};
        channel1.read(bufs);
        for(ByteBuffer byteBuffer:bufs) {
            byteBuffer.flip();
        }
        //聚集写入
        RandomAccessFile raf2=new RandomAccessFile("2.jpg", "rw");
        FileChannel channel2=raf2.getChannel();
        channel2.write(bufs);
    }


}
