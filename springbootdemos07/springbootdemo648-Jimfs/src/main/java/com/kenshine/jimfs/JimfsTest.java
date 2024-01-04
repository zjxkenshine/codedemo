package com.kenshine.jimfs;

import com.google.common.collect.ImmutableList;
import com.google.common.jimfs.Configuration;
import com.google.common.jimfs.Jimfs;
import org.junit.Test;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.DirectoryStream;
import java.nio.file.FileSystem;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

/**
 * @author by kenshine
 * @Classname JimfsTest
 * @Description jimfs使用测试
 * @Date 2024-01-04 8:22
 * @modified By：
 * @version: 1.0$
 */
public class JimfsTest {

    /**
     * unix格式的文件系统
     */
    @Test
    public void test01() throws IOException {
        // unix格式的文件系统
        FileSystem fs = Jimfs.newFileSystem(Configuration.unix());
        Path foo = fs.getPath("/foo");
        Files.createDirectory(foo);

        // /foo/hello.txt
        Path hello = foo.resolve("hello.txt");
        Files.write(hello, ImmutableList.of("hello world"), StandardCharsets.UTF_8);

        // 遍历路径下的文件
        List<Path> files = new ArrayList<>();
        DirectoryStream<Path> stream= Files.newDirectoryStream(foo);
        for (Path entry : stream){
            files.add(entry);
        }
        stream.close();
        // 打印/foo下所有文件路径
        for (Path entry: files){
            System.out.println(entry.toString());
        }
    }

}
