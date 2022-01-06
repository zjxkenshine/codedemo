package com.kenshine.io.Test21_RandomAccessFile;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.RandomAccessFile;

/**
 * @author ：kenshine
 * @date ：Created in 2022/1/6 22:09
 * @description：
 * @modified By：
 * @version: $
 */
public class RAFTestFactory {
    private static final String url = "F:\\IDEAworkespace\\codedemo\\java-demo\\java-io-demo\\src\\main\\resources\\test20\\test20.txt";
    private static final String [] model = {"r","rw","rws","rwd"};

    public static RandomAccessFile getRAFWithModelR() throws FileNotFoundException {
        RandomAccessFile raf = new RandomAccessFile(new File(url), model[0]);
        return raf;
    }

    public static RandomAccessFile getRAFWithModelRW() throws FileNotFoundException {
        RandomAccessFile raf = new RandomAccessFile(new File(url), model[1]);
        return raf;
    }

    public static RandomAccessFile getRAFWithModelRWS() throws FileNotFoundException {
        RandomAccessFile raf = new RandomAccessFile(new File(url), model[2]);
        return raf;
    }

    public static RandomAccessFile getRAFWithModelRWD() throws FileNotFoundException {
        RandomAccessFile raf = new RandomAccessFile(new File(url), model[3]);
        return raf;
    }

}
