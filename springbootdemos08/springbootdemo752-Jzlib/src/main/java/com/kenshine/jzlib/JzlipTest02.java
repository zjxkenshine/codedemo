package com.kenshine.jzlib;

import com.jcraft.jzlib.*;
import org.junit.Test;

/**
 * @author by kenshine
 * @Classname JzlipTest02
 * @Description Gzip压缩解压
 * @Date 2024-03-18 9:26
 * @modified By：
 * @version: 1.0$
 */
public class JzlipTest02 {

    @Test
    public void test02(){
        byte[] hello="hello".getBytes();
        int err;

        int comprLen=40000;
        int uncomprLen=comprLen;
        byte[] compr=new byte[comprLen];
        byte[] uncompr=new byte[uncomprLen];

        Deflater deflater = null;
        try{
            deflater = new Deflater(JZlib.Z_DEFAULT_COMPRESSION, JZlib.DEF_WBITS + 16);
        }
        catch(GZIPException e){
            // never happen, because arguments are valid.
        }

        deflater.setInput(hello);
        deflater.setOutput(compr);

        while(deflater.total_in!=hello.length &&
                deflater.total_out<comprLen){
            deflater.avail_in=deflater.avail_out=1;
            err=deflater.deflate(JZlib.Z_NO_FLUSH);
            CHECK_ERR(deflater, err, "deflate");
        }

        while(true){
            deflater.avail_out=1;
            err=deflater.deflate(JZlib.Z_FINISH);
            if(err==JZlib.Z_STREAM_END)break;
            CHECK_ERR(deflater, err, "deflate");
        }

        err=deflater.end();
        CHECK_ERR(deflater, err, "deflateEnd");

        Inflater inflater = null;
        try {
            inflater = new Inflater(JZlib.DEF_WBITS + 32);
        }
        catch(GZIPException ignored){
        }

        inflater.setInput(compr);
        inflater.setOutput(uncompr);

        while(inflater.total_out<uncomprLen &&
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
                return;
            }
        }
        else{
            System.out.println("bad inflate");
        }
    }

    // 检查错误
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
