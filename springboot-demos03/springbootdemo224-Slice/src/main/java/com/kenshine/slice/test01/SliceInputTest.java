package com.kenshine.slice.test01;

import com.kenshine.slice.util.ConverterUtils;
import io.airlift.slice.InputStreamSliceInput;
import io.airlift.slice.SliceInput;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * @author ：kenshine
 * @date ：Created in 2022/1/16 11:15
 * @description：
 * @modified By：
 * @version: $
 * SliceInput和SliceOutput测试
 */
public class SliceInputTest {

    private SliceInput buildSliceInput(byte[] bytes) {
        ByteArrayInputStream inputStream = new ByteArrayInputStream(bytes);
        return new InputStreamSliceInput(inputStream, 16 * 1024);
    }

    /**
     * InputStreamSliceInput 读取数据
     */
    @Test
    public void test01() throws FileNotFoundException {
        FileInputStream fis = new FileInputStream(new File("F:\\IDEAworkespace\\codedemo\\springboot-demos03\\springbootdemo224-Slice\\src\\main\\resources\\test01\\test01.txt"));
        InputStreamSliceInput issi = new InputStreamSliceInput(fis);
//        String line;
//        while((line=issi.readLine())!=null){
//            System.out.println(line);     //暂不支持ReadLine
//        }
        //读取文件
        byte[] bytes=new byte[1024];    //每次读取1024字节
        //记录每次读取到的字节/个数
        int len=0;
        while((len=issi.read(bytes))!=-1){
            System.out.println(new String(bytes,0,len));
        }
        //4.释放资源(仅关闭缓冲流即可)
        issi.close();
    }

    /**
     * 一些读取方法测试
     */
    @Test
    public void test02(){
        //布尔类型
        System.out.println(buildSliceInput(new byte[] {1}).readBoolean());  //true
        System.out.println(buildSliceInput(new byte[] {0}).readBoolean());  //false
        //int类型
        System.out.println(buildSliceInput(ConverterUtils.intToBytes(100)).readInt());  //100
        //double类型
        System.out.println(buildSliceInput(new byte[] {31, -123, -21, 81, -72, 30, 9, 64}).readDouble());   //3.14
    }


}
