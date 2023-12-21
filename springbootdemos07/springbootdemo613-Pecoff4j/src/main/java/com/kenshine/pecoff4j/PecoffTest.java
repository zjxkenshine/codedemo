package com.kenshine.pecoff4j;

import com.kichik.pecoff4j.CLRRuntimeHeader;
import com.kichik.pecoff4j.PE;
import com.kichik.pecoff4j.ResourceDirectory;
import com.kichik.pecoff4j.ResourceEntry;
import com.kichik.pecoff4j.constant.ResourceType;
import com.kichik.pecoff4j.io.DataReader;
import com.kichik.pecoff4j.io.DataWriter;
import com.kichik.pecoff4j.io.IDataWriter;
import com.kichik.pecoff4j.io.PEParser;
import com.kichik.pecoff4j.resources.StringFileInfo;
import com.kichik.pecoff4j.resources.StringPair;
import com.kichik.pecoff4j.resources.StringTable;
import com.kichik.pecoff4j.resources.VersionInfo;
import com.kichik.pecoff4j.util.IconExtractor;
import com.kichik.pecoff4j.util.ResourceHelper;
import org.junit.Test;

import java.io.*;
import java.util.List;

/**
 * @author by kenshine
 * @Classname PecoffTest
 * @Description Pecoff4j使用测试
 * @Date 2023-12-21 8:58
 * @modified By：
 * @version: 1.0$
 */
public class PecoffTest {

    /**
     * PE解析exe文件
     */
    @Test
    public void test01() throws IOException {
        PE pe = PEParser.parse("D:\\Program1\\Notepad++\\notepad++.exe");
        ResourceDirectory rd = pe.getImageData().getResourceTable();

        ResourceEntry[] entries = ResourceHelper.findResources(rd, ResourceType.VERSION_INFO);
        for (int i = 0; i < entries.length; i++) {
            byte[] data = entries[i].getData();
            VersionInfo version = VersionInfo.read(new DataReader(data));
            //文件信息
            StringFileInfo strings = version.getStringFileInfo();
            StringTable table = strings.getTable(0);
            for(int j=0;j<table.getCount();j++){
                StringPair pair=table.getString(j);
                System.out.println(pair.getKey() + " = " + pair.getValue());
            }
        }
    }

    /**
     * 解析dll文件头
     */
    @Test
    public void test02() throws IOException {
        InputStream in = new FileInputStream("src\\main\\resources\\clr\\ClassLibrary.dll");
        PE pe = PEParser.parse(in);
        CLRRuntimeHeader clrRuntimeHeader = pe.getImageData().getClrRuntimeHeader();
        System.out.println(clrRuntimeHeader.getHeaderSize());
    }

    /**
     * 读写exe
     */
    @Test
    public void test03() throws IOException {
        PE pe = PEParser.parse(new FileInputStream("src\\main\\resources\\WinRun4J.exe"));
        IDataWriter writer = new DataWriter(new File("out\\test01.exe"));
        pe.write(writer);
    }

    /**
     * 读写dll
     */
    @Test
    public void test04() throws IOException {
        PE pe = PEParser.parse(new FileInputStream("src\\main\\resources\\clr\\ClassLibrary.dll"));
        IDataWriter writer = new DataWriter(new File("out\\test02.dll"));
        pe.write(writer);
    }

    /**
     * 图标提取
     */
    @Test
    public void test05() throws IOException {
        File exe = new File("src\\main\\resources\\WinRun4J.exe");
        File output = new File("out");
        IconExtractor.extract(exe, output);
    }

    /**
     * 版本信息
     */
    @Test
    public void test06() throws IOException {
        VersionInfo version = getVersionInfo();
        //StringFileInfo
        StringFileInfo stringFileInfo = version.getStringFileInfo();
        StringTable table=stringFileInfo.getTable(0);
        for(int j=0;j<table.getCount();j++){
            StringPair pair=table.getString(j);
            System.out.println(pair.getKey() + " = " + pair.getValue());
        }
    }


    /**
     * 获取版本信息
     */
    public VersionInfo getVersionInfo() throws IOException {
        PE pe = PEParser.parse(new FileInputStream("src\\main\\resources\\WinRun4J.exe"));
        ResourceDirectory rd = pe.getImageData().getResourceTable();
        ResourceEntry[] entries = ResourceHelper.findResources(rd, ResourceType.VERSION_INFO);
        return VersionInfo.read(new DataReader(entries[0].getData()));
    }
}
