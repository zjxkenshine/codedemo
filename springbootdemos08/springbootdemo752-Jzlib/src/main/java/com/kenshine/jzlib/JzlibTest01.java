package com.kenshine.jzlib;

import com.jcraft.jzlib.*;
import org.junit.Test;

/**
 * @author by kenshine
 * @Classname JzlibTest01
 * @Description 基本压缩解压
 * @Date 2024-03-18 9:11
 * @modified By：
 * @version: 1.0$
 */
public class JzlibTest01 {

    /**
     * 基础压缩解压实现
     */
    @Test
    public void test01(){
        byte[] hello="hello, hello! ".getBytes();
        int err;
        int comprLen=40000;
        byte[] compr=new byte[comprLen];
        byte[] uncompr=new byte[comprLen];

        Deflater deflater = null;

        try {
            // 默认压缩方式
            deflater = new Deflater(JZlib.Z_DEFAULT_COMPRESSION);
        }
        catch(GZIPException e){
            // never happen, because argument is valid.
        }
        // 设置输入输出
        deflater.setInput(hello);
        deflater.setOutput(compr);

        // 进行压缩
        while(deflater.total_in!=hello.length &&
                deflater.total_out<comprLen){
            // 设置deflater对象的输入和输出可用字节数为1
            deflater.avail_in=deflater.avail_out=1;
            // 进行压缩 Z_NO_FLUSH，它表示在压缩过程中不进行刷新操作，可以提高压缩效率
            err=deflater.deflate(JZlib.Z_NO_FLUSH);
            CHECK_ERR(deflater, err, "deflate");
        }

        // 数据压缩
        while(true){
            deflater.avail_out=1;
            err=deflater.deflate(JZlib.Z_FINISH);
            if(err==JZlib.Z_STREAM_END) {
                break;
            }
            CHECK_ERR(deflater, err, "deflate");
        }

        // 结束压缩
        err=deflater.end();
        CHECK_ERR(deflater, err, "deflateEnd");

        //======================================================
        // 解压
        Inflater inflater = new Inflater();

        inflater.setInput(compr);
        inflater.setOutput(uncompr);

        err=inflater.init();
        CHECK_ERR(inflater, err, "inflateInit");
        // 进行解压
        while(inflater.total_out< comprLen &&
                inflater.total_in<comprLen) {
            inflater.avail_in=inflater.avail_out=1;
            err=inflater.inflate(JZlib.Z_NO_FLUSH);
            if(err==JZlib.Z_STREAM_END) {
                break;
            }
            CHECK_ERR(inflater, err, "inflate");
        }

        err=inflater.end();
        CHECK_ERR(inflater, err, "inflateEnd");

        int i=0;
        for(;i<hello.length; i++) {
            if(hello[i]==0) {
                break;
            }
        }
        int j=0;
        for(;j<uncompr.length; j++) {
            if(uncompr[j]==0) {
                break;
            }
        }

        if(i==j){
            for(i=0; i<j; i++) {
                if(hello[i]!=uncompr[i]) {
                    break;
                }
            }
            if(i==j){
                System.out.println("inflate(): "+new String(uncompr, 0, j));
            }
        }else{
            System.out.println("bad inflate");
        }
    }

    /**
     * 检查错误
     */
    public void CHECK_ERR(ZStream z, int err, String msg) {
        if(err!=JZlib.Z_OK){
            if(z.msg!=null) {
                System.out.print(z.msg+" ");
            }
            System.out.println(msg+" error: "+err);
            System.exit(1);
        }
    }

}
