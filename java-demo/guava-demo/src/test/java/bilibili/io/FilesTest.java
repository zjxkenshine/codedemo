package bilibili.io;

import com.google.common.base.Charsets;
import com.google.common.base.Joiner;
import com.google.common.collect.FluentIterable;
import com.google.common.hash.HashCode;
import com.google.common.hash.Hashing;
import com.google.common.io.FileWriteMode;
import com.google.common.io.Files;
import com.google.common.io.LineProcessor;
import org.hamcrest.core.IsEqual;
import org.junit.After;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;

/**
 * @author ：kenshine
 * @date ：Created in 2021/10/25 16:18
 * @description：Files 文件测试
 * @modified By：
 * @version: $
 */
public class FilesTest {

    private final String SOURCE_FILE = "F:\\IDEAworkespace\\codedemo\\java-demo\\guava-demo\\src\\test\\resources\\io\\source.txt";
    private final String TARGET_FILE = "F:\\IDEAworkespace\\codedemo\\java-demo\\guava-demo\\src\\test\\resources\\io\\target.txt";

    /**
     * 文件拷贝测试
     * @throws IOException
     */
    @Test
    public void testCopyFileWithGuava() throws IOException {
        File targetFile = new File(TARGET_FILE);
        Files.copy(new File(SOURCE_FILE),targetFile);
        System.out.println(targetFile.exists());
    }

    /**
     * Java NIO 文件拷贝测试
     */
    @Test
    public void testCopyWithJDKNio2() throws IOException {
        java.nio.file.Files.copy(
                Paths.get("F:\\IDEAworkespace\\codedemo\\java-demo\\guava-demo\\src\\test\\resources","io","source.txt"),
                Paths.get("F:\\IDEAworkespace\\codedemo\\java-demo\\guava-demo\\src\\test\\resources","io","target.txt"),
                StandardCopyOption.REPLACE_EXISTING
        );
    }


    /**
     * 测试移动文件
     */
    @Test
    public void testMoveFile() throws IOException {
        //最好在方法内生成文件，测试完毕统一删除，防止失败后影响测试环境
        try {
            Files.move(new File(SOURCE_FILE),new File(TARGET_FILE));
            assertThat(new File(TARGET_FILE).exists(), IsEqual.equalTo(true));
            assertThat(new File(SOURCE_FILE).exists(), IsEqual.equalTo(false));
        }finally {
            Files.move(new File(TARGET_FILE),new File(SOURCE_FILE));
        }
    }

    /**
     *  读取文件字符串
     */
    @Test
    public void testFileToString() throws IOException {
        List<String> stringList = Files.readLines(new File(SOURCE_FILE), Charsets.UTF_8);
        String result = Joiner.on("").join(stringList);
        System.out.println(result);
    }



    /**
     *  读取文件字符串后加工
     */
    @Test
    public void testFileToString_Process() throws IOException {

        /**
         * 行解析器
         */
        LineProcessor<List<Integer>> lineProcessor = new LineProcessor<List<Integer>>() {

            private  final List<Integer> line = new ArrayList<>();
            /**
             * 处理行
             * @param s
             * @return
             * @throws IOException
             */
            @Override
            public boolean processLine(String s) throws IOException {
                line.add(s.length());
                return true;
            }

            /**
             * 获取结果
             * @return
             */
            @Override
            public List<Integer> getResult() {
                return line;
            }
        };

        List<Integer> result = Files.asCharSource(new File(SOURCE_FILE),Charsets.UTF_8).readLines(lineProcessor);
        System.out.println(result);
    }

    /**
     * 获取文件md5值
     * sha值
     */
    @Test
    public void testFileMd5() throws IOException {
        //sha256加密
        //Hashing 中有其他加密算法
        HashCode hashCode =Files.asByteSource(new File(SOURCE_FILE)).hash(Hashing.sha256());
        System.out.println(hashCode);
    }

    /**
     * 写文件
     */
    @Test
    public void testFileWrite() throws IOException {
        final String PATH = "F:\\IDEAworkespace\\codedemo\\java-demo\\guava-demo\\src\\test\\resources\\io\\testFileWrite.txt";
        File testFile = new File(PATH);
        testFile.deleteOnExit();
        String content = "hello guava";
        //写文件
        Files.asCharSink(testFile,Charsets.UTF_8).write(content);
        //读取
        String result = Files.asCharSource(testFile,Charsets.UTF_8).read();
        System.out.println(result);
    }

    /**
     * appen方式写文件
     */
    @Test
    public void  testFileAppend() throws IOException {
        final String PATH = "F:\\IDEAworkespace\\codedemo\\java-demo\\guava-demo\\src\\test\\resources\\io\\testFileWrite.txt";
        File testFile = new File(PATH);
        testFile.deleteOnExit();
        String content = "hello guava02";
        //写文件 指定mode append
        Files.asCharSink(testFile,Charsets.UTF_8, FileWriteMode.APPEND).write(content);
        //读取
        String result = Files.asCharSource(testFile,Charsets.UTF_8).read();
        System.out.println(result);
    }

    /**
     * touch创建文件
     */
    @Test
    public void testFileTouch() throws IOException {
        final String PATH = "F:\\IDEAworkespace\\codedemo\\java-demo\\guava-demo\\src\\test\\resources\\io\\testFileTouch.txt";
        File touchFile = new File(PATH);
        touchFile.deleteOnExit();
        Files.touch(touchFile);
        assertThat(touchFile.exists(),IsEqual.equalTo(true));
    }


    /**
     * 递归 操作文件夹 自己实现
     */
    @Test
    public void testRecursive(){
        ArrayList<File> files=new ArrayList<>();
        recursive(new File("F:\\IDEAworkespace\\codedemo\\java-demo\\guava-demo\\src\\main\\java\\bilibili\\utilites"),files);
        System.out.println(files);
    }

    private void recursive(File root,List<File> fileList){
        if(root.isHidden()){
            return;
        }
        fileList.add(root);
        //递归路径和文件
        if(!root.isFile()){
            File[] files = root.listFiles();
            for(File f:files){
                recursive(f,fileList);
            }
        }
    }


    /**
     * guava文件树操作
     */
    @Test
    public void testTreeFiles(){
        File root = new File("F:\\IDEAworkespace\\codedemo\\java-demo\\guava-demo\\src\\main\\java\\bilibili\\utilites");
        /**
         *  正序 depthFirstPreOrder
         *  倒序 depthFirstPostOrder
         */
        Iterable<File> files = Files.fileTraverser().depthFirstPreOrder(root);
        //过滤文件夹
        FluentIterable<File> files1 = FluentIterable.concat(files).filter(File::isFile);
        files1.stream().forEach(System.out::println);
    }


    /**
     * 文件树 按文件路径长度排序
     */
    @Test
    public void testTreeFilesBreadthFirst(){
        File root = new File("F:\\IDEAworkespace\\codedemo\\java-demo\\guava-demo\\src\\main\\java\\bilibili\\utilites");
        Iterable<File> files = Files.fileTraverser().breadthFirst(root);
        //过滤文件夹
        FluentIterable<File> files1 = FluentIterable.concat(files).filter(File::isFile);
        files1.stream().forEach(System.out::println);
    }


    /**
     * 测试完清空target文件
     * 测试前与测试号环境需要一致
     */
    @After
    public void tearDown(){
        File targetFile = new File(TARGET_FILE);
        if(targetFile.exists()){
            targetFile.delete();
        }
    }


}
