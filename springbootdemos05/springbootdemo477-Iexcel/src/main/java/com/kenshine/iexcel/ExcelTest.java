package com.kenshine.iexcel;

import com.github.houbb.heaven.util.io.FileUtil;
import com.github.houbb.heaven.util.nio.PathUtil;
import com.github.houbb.iexcel.bs.ExcelBs;
import com.github.houbb.iexcel.core.reader.IExcelReader;
import com.github.houbb.iexcel.core.writer.IExcelWriter;
import com.github.houbb.iexcel.exception.ExcelRuntimeException;
import com.github.houbb.iexcel.util.ExcelHelper;
import com.github.houbb.iexcel.util.excel.ExcelUtil;
import com.kenshine.iexcel.model.User;
import com.kenshine.iexcel.model.UserField;
import org.junit.Test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

/**
 * @author ：kenshine
 * @date ：Created in 2023/11/12 20:10
 * @description：测试
 * @modified By：
 * @version: $
 */
public class ExcelTest {

    /**
     * 读取与写入
     */
    @Test
    public void test01(){
        // 基本属性
        final String filePath = PathUtil.getAppTestResourcesPath()+"/test.xls";
        List<User> models = User.buildUserList();
        // 直接写入到文件
        ExcelHelper.write(filePath, models);

        // 读取
        List<User> userList = ExcelHelper.read(filePath, User.class);
        System.out.println(userList);
    }

    /**
     * 写入到 03 excel 文件
     */
    @Test
    public void test02(){
        // 待生成的 excel 文件路径
        final String filePath = PathUtil.getAppTestResourcesPath()+"/excelWriter03.xls";

        // 对象列表
        List<User> models = User.buildUserList();

        try(IExcelWriter excelWriter = ExcelUtil.get03ExcelWriter();
            OutputStream outputStream = new FileOutputStream(filePath)) {
            // 可根据实际需要，多次写入列表
            excelWriter.write(models);

            // 将列表内容真正的输出到 excel 文件
            excelWriter.flush(outputStream);
        } catch (IOException e) {
            throw new ExcelRuntimeException(e);
        }
    }

    /**
     * 一次性写入到 2007 excel
     */
    @Test
    public void onceWriterAndFlush07Test() {
        // 待生成的 excel 文件路径
        final String filePath = PathUtil.getAppTestResourcesPath()+"/onceWriterAndFlush07.xlsx";
        // 对象列表
        List<User> models = User.buildUserList();
        // 对应的 excel 写入对象
        IExcelWriter excelWriter = ExcelUtil.get07ExcelWriter();
        // 只写入一次列表
        ExcelUtil.onceWriteAndFlush(excelWriter, models, filePath);
    }


    /**
     * 读取
     */
    @Test
    public void test03(){
        File file = new File(PathUtil.getAppTestResourcesPath()+"/excelWriter03.xls");
        IExcelReader<User> excelReader = ExcelUtil.getExcelReader(file);
        List<User> models = excelReader.readAll(User.class);
        System.out.println(models);
    }

    /**
     * ExcelField注解指定表头名称
     */
    @Test
    public void test04(){
        // 基本属性
        final String filePath = PathUtil.getAppTestResourcesPath()+"/testField.xls";
        List<UserField> models = UserField.buildUserList();
        // 直接写入到文件
        ExcelHelper.write(filePath, models);
    }

    /**
     *   获取文件字节信息
      */
    @Test
    public void test05(){
        // 获取对应文件流
        byte[] bytes = ExcelBs.newInstance()
                .append(User.buildUserList())
                .bytes();
        // 根据文件内容，自行选择应用场景，到如 web 下载。
        final String filePath = PathUtil.getAppTestResourcesPath()+"/bytes.xls";
        // 字节输出到文件
        FileUtil.createFile(filePath, bytes);
    }
}
