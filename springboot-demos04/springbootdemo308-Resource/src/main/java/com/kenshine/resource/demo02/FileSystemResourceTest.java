package com.kenshine.resource.demo02;

import org.springframework.core.io.FileSystemResource;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

/**
 * @author ：kenshine
 * @date ：Created in 2022/1/4 22:55
 * @description：
 * @modified By：
 * @version: $
 */
public class FileSystemResourceTest {
    public static void main(String[] args) throws IOException {
        FileSystemResource fileSystemResource = new FileSystemResource("d:/a.txt");
        OutputStream outputStream = fileSystemResource.getOutputStream();
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));
        bufferedWriter.write("Hello World");
        bufferedWriter.flush();
        outputStream.close();
        bufferedWriter.close();
    }
}
