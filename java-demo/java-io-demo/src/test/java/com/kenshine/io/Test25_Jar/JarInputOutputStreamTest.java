package com.kenshine.io.Test25_Jar;

import org.junit.Test;

import java.io.*;
import java.util.Enumeration;
import java.util.Objects;
import java.util.jar.*;
import java.util.logging.Logger;
import java.util.zip.ZipEntry;

/**
 * @author ：kenshine
 * @date ：Created in 2022/1/6 22:43
 * @description：
 * @modified By：
 * @version: $
 */
public class JarInputOutputStreamTest {
    Logger log = Logger.getLogger("JarInputOutputStreamTest");

    /**
     * 打包jar文件测试
     */
    @Test
    public void testAddJar() throws IOException {
        Manifest manifest = new Manifest();
        manifest.getMainAttributes().put(Attributes.Name.MANIFEST_VERSION, "1.0");
        JarOutputStream target = new JarOutputStream(new FileOutputStream("F:\\IDEAworkespace\\codedemo\\java-demo\\java-io-demo\\src\\main\\resources\\test25\\output.jar"), manifest);
        add(new File("F:\\IDEAworkespace\\codedemo\\java-demo\\java-io-demo\\src\\main\\resources\\test25\\test"), target);
        target.close();
    }

    /*
     * 1.JarInputStream的getNextJarEntry()和jarOutputStream的putNextJarEntry()中没有包括"META-INF/MANIFEST.MF"这一项,因此复制和解压都	要注意
     * 2.JarFile的entries()方法包含了全部Entry,也包括"META-INF/MANIFEST.MF",没有"META-INF/"这一项,因此在解压的时候要先检测父文件存不存在
     * 4.复制jar文件有3中方法, A是直接用BufferedInputStream和BufferedOutputStream复制,
     *                      B是用JarInputStream的getNextJarEntry()和jarOutputStream的putNextJarEntry()
     *                      C是用JarFile的entries()方法,遍寻JarEntry的InputStream,以此写出
     * 5.解压jar的话推荐使用JarFile,当前实例方法只支持解压jar文件
     * 6.在复制的时候,src文件只可以是jar文件,但des文件可以是带zip或rar后缀的文件
     */
    @Test
    public void testCopyJar(){
        File src = new File("F:\\IDEAworkespace\\codedemo\\java-demo\\java-io-demo\\src\\main\\resources\\test25\\output.jar");
        File des = new File("F:\\IDEAworkespace\\codedemo\\java-demo\\java-io-demo\\src\\main\\resources\\test25\\copy.jar");
        //只运行复制和解压jar文件
//        File src = new File("C:/rtf.zip");
//        File des = new File("C:/testCopy.zip");
        try {
            copyJar(src,des);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 解压jar
     */
    @Test
    public void testUnJar(){
        File src = new File("F:\\IDEAworkespace\\codedemo\\java-demo\\java-io-demo\\src\\main\\resources\\test25\\copy.jar");
//        File src = new File("C:/b.rar");    //不支持rar解压
        String desFile = "aa";
        File desDir = new File(src.getParent()+File.separator+desFile);
        try {
            unJar(src, desDir);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * JarFile复制jar文件
     */
    @Test
    public void testCopyJarByJarFile(){
        File src = new File("C:/a.jar");
        File des = new File("C:/testCopy.zip");
        try {
            copyJarByJarFile(src,des);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * JarFile 解压jar
     */
    @Test
    public void testUnJarByJarFile(){
        File src = new File("C:/a.jar");
//        File src = new File("C:/b.rar");    //不支持rar解压
        String desFile = "aa";
        File desDir = new File(src.getParent()+ File.separator+desFile);
        try {
            unJarByJarFile(src, desDir);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //复制jar
    public static void copyJar(File src , File des) throws IOException{
        JarInputStream jarIn = new JarInputStream(new BufferedInputStream(new FileInputStream(src)));
        Manifest manifest = jarIn.getManifest();
        JarOutputStream jarOut = null;
        if(manifest == null){
            jarOut = new JarOutputStream(new BufferedOutputStream(new FileOutputStream(des)));
        }else{
            jarOut = new JarOutputStream(new BufferedOutputStream(new FileOutputStream(des)),manifest);
        }

        byte[] bytes = new byte[1024];
        while(true){
            //重点
            ZipEntry entry = jarIn.getNextJarEntry();
            if(entry == null)break;
            jarOut.putNextEntry(entry);

            int len = jarIn.read(bytes, 0, bytes.length);
            while(len != -1){
                jarOut.write(bytes, 0, len);
                len = jarIn.read(bytes, 0, bytes.length);
            }
            String a = new String();
            a.length();
        }
        jarIn.close();
        jarOut.finish();
        jarOut.close();
    }

    //解压jar
    public void unJar(File src , File desDir) throws IOException{
        JarInputStream jarIn = new JarInputStream(new BufferedInputStream(new FileInputStream(src)));
        if(!desDir.exists())desDir.mkdirs();
        byte[] bytes = new byte[1024];

        while(true){
            ZipEntry entry = jarIn.getNextJarEntry();
            if(entry == null)break;

            File desTemp = new File(desDir.getAbsoluteFile() + File.separator + entry.getName());

            if(entry.isDirectory()){    //jar条目是空目录
                if(!desTemp.exists())desTemp.mkdirs();
                log.info("MakeDir: " + entry.getName());
            }else{    //jar条目是文件
                BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(desTemp));
                int len = jarIn.read(bytes, 0, bytes.length);
                while(len != -1){
                    out.write(bytes, 0, len);
                    len = jarIn.read(bytes, 0, bytes.length);
                }
                out.flush();
                out.close();
                log.info("Copyed: " + entry.getName());
            }
            jarIn.closeEntry();
        }

        //解压Manifest文件
        Manifest manifest = jarIn.getManifest();
        if(manifest != null){
            File manifestFile = new File(desDir.getAbsoluteFile()+File.separator+ JarFile.MANIFEST_NAME);
            if(!manifestFile.getParentFile().exists())manifestFile.getParentFile().mkdirs();
            BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(manifestFile));
            manifest.write(out);
            out.close();
        }
        //关闭JarInputStream
        jarIn.close();
    }


    //复制jar by JarFile
    public void copyJarByJarFile(File src , File des) throws IOException{
        //重点
        JarFile jarFile = new JarFile(src);
        Enumeration<JarEntry> jarEntrys = jarFile.entries();
        JarOutputStream jarOut = new JarOutputStream(new BufferedOutputStream(new FileOutputStream(des)));
        byte[] bytes = new byte[1024];

        while(jarEntrys.hasMoreElements()){
            JarEntry entryTemp = jarEntrys.nextElement();
            jarOut.putNextEntry(entryTemp);
            BufferedInputStream in = new BufferedInputStream(jarFile.getInputStream(entryTemp));
            int len = in.read(bytes, 0, bytes.length);
            while(len != -1){
                jarOut.write(bytes, 0, len);
                len = in.read(bytes, 0, bytes.length);
            }
            in.close();
            jarOut.closeEntry();
            log.info("Copyed: " + entryTemp.getName());
        }
        jarOut.finish();
        jarOut.close();
        jarFile.close();
    }

    //解压jar文件by JarFile
    public void unJarByJarFile(File src , File desDir) throws IOException{
        JarFile jarFile = new JarFile(src);
        Enumeration<JarEntry> jarEntrys = jarFile.entries();
        if(!desDir.exists())desDir.mkdirs(); //建立用户指定存放的目录
        byte[] bytes = new byte[1024];

        while(jarEntrys.hasMoreElements()){
            ZipEntry entryTemp = jarEntrys.nextElement();
            File desTemp = new File(desDir.getAbsoluteFile() + File.separator + entryTemp.getName());

            if(entryTemp.isDirectory()){    //jar条目是空目录
                if(!desTemp.exists())desTemp.mkdirs();
                log.info("makeDir" + entryTemp.getName());
            }else{    //jar条目是文件
                //因为manifest的Entry是"META-INF/MANIFEST.MF",写出会报"FileNotFoundException"
                File desTempParent = desTemp.getParentFile();
                if(!desTempParent.exists())desTempParent.mkdirs();

                BufferedInputStream in = new BufferedInputStream(jarFile.getInputStream(entryTemp));
                BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(desTemp));

                int len = in.read(bytes, 0, bytes.length);
                while(len != -1){
                    out.write(bytes, 0, len);
                    len = in.read(bytes, 0, bytes.length);
                }

                in.close();
                out.flush();
                out.close();
                log.info("Copyed: " + entryTemp.getName());
            }
        }
        jarFile.close();
    }



    private void add(File source, JarOutputStream target) throws IOException{
        BufferedInputStream in = null;
        try {
            if (source.isDirectory()) {
                //JarEntry 的名称
                String name = source.getPath().replace("\\", "/");
                if (!name.isEmpty()) {
                    if (!name.endsWith("/"))
                        name += "/";
                    JarEntry entry = new JarEntry(name);
                    entry.setTime(source.lastModified());
                    target.putNextEntry(entry);
                    target.closeEntry();
                }
                for (File nestedFile: Objects.requireNonNull(source.listFiles()))
                    add(nestedFile, target);
                return;
            }

            JarEntry entry = new JarEntry(source.getPath().replace("\\", "/"));
            entry.setTime(source.lastModified());
            target.putNextEntry(entry);
            in = new BufferedInputStream(new FileInputStream(source));

            byte[] buffer = new byte[1024];
            while (true) {
                int count = in.read(buffer);
                if (count == -1)
                    break;
                target.write(buffer, 0, count);
            }
            target.closeEntry();
        } finally {
            if (in != null)
                in.close();
        }
    }

}
