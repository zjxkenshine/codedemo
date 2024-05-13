package com.kenshine.easyfile;

import idea.verlif.easy.file.domain.FileHolder;
import idea.verlif.easy.file.page.FilePage;
import idea.verlif.easy.file.page.FileQuery;
import idea.verlif.easy.file.util.FileUtil;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;

/**
 * @author by kenshine
 * @Classname EasyFileTest
 * @Description EasyFile测试
 * @Date 2024-05-13 9:20
 * @modified By：
 * @version: 1.0$
 */
public class EasyFileTest {

    /**
     * 级联搜索
     */
    @Test
    public void test01(){
        // 新建FileHolder对象
        FileHolder holder = new FileHolder("F:\\Github\\dbvisitor\\dbvisitor\\src\\main\\java\\net\\hasor\\dbvisitor");
        // 新建查询条件
        FileQuery query = new FileQuery();
        // 设置查询过滤，这里使用的是FileFilter。实例表示只查询文件名带有"page"的文件
        query.setFileFilter(pathname -> pathname.getName().toUpperCase().contains("PAGE"));
        // 设置结果排序，这里使用的是Comparator<File>。下面的实例表示文件夹优先且短文件名优先
        query.setComparator((o1, o2) -> {
            if (o1.isDirectory() && o2.isFile()) {
                return -1;
            }
            if (o2.isDirectory() && o1.isFile()) {
                return 1;
            }
            return o1.getName().length() - o2.getName().length();
        });
        // 不分页大小
        query.setSize(-1);
        // 开始查询
        FilePage page = holder.searchPage(query);
        System.out.println(page);
    }

    /**
     * 文件读写
     */
    @Test
    public void test02(){
        File file = new File("file\\a.txt");
        FileUtil.writeStringToFile(file, "kenshine kenshine！");
        System.out.println(FileUtil.readContentAsString(file));
    }

    /**
     * 文件复制
     */
    @Test
    public void test03() throws FileNotFoundException {
        File file = new File("file\\t1.txt");
        FileUtil.writeStringToFile(file, "Hello kenshine!");
        System.out.println(FileUtil.readContentAsString(file));
        // 复制文件夹
        FileUtil.copyFile(file.getParentFile(), "file\\copy", true);
    }


}
