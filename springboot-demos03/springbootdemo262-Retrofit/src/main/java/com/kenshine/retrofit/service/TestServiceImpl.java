package com.kenshine.retrofit.service;

import com.kenshine.retrofit.api.HttpApi;
import com.kenshine.retrofit.domain.TestEntity;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.ResponseBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import retrofit2.Response;
import retrofit2.http.Body;

import javax.annotation.Resource;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

/**
 * @author ：kenshine
 * @date ：Created in 2023/10/16 23:27
 * @description：
 * @modified By：
 * @version: $
 */
@Service
public class TestServiceImpl implements TestService{
    //注入 retrofitTest
    @Resource
    private HttpApi retrofitTest;

    //这是上传文件的代码，需对文件名使用URLEncoder进行编码
    public void upload(MultipartFile file) throws IOException {
        String fileName = URLEncoder.encode(Objects.requireNonNull(file.getOriginalFilename()),"utf-8");
        okhttp3.RequestBody requestBody=okhttp3.RequestBody.create(MediaType.parse("multipart/form-data"),file.getBytes());
        MultipartBody.Part part = MultipartBody.Part.createFormData("file",fileName,requestBody);
        //处理完成，调用请求
        retrofitTest.upload(part);
    }

    //这是下载文件的代码
    public void download() throws Exception {
        String fileKey = "6302d742-ebc8-4649-95cf-62ccf57a1add";
        //调用请求
        Response response = retrofitTest.download(fileKey);
        ResponseBody responseBody = (ResponseBody) response.body();
        // 二进制流
        InputStream is = responseBody.byteStream();

        // 具体如何处理二进制流，由业务自行控制。这里以写入文件为例
        File tempDirectory = new File("temp");
        if (!tempDirectory.exists()) {
            tempDirectory.mkdir();
        }
        File file = new File(tempDirectory, UUID.randomUUID().toString());
        if (!file.exists()) {
            file.createNewFile();
        }
        FileOutputStream fos = new FileOutputStream(file);
        byte[] b = new byte[1024];
        int length;
        while ((length = is.read(b)) > 0) {
            fos.write(b, 0, length);
        }
        is.close();
        fos.close();
    }

    @Override
    public void test01() {
        retrofitTest.getTest();
    }

    @Override
    public List<TestEntity> test02() {
        return retrofitTest.postList( new TestEntity(1,1));
    }

    @Override
    public List<TestEntity> test03() {
        return retrofitTest.getList2(5L);
    }

    @Override
    public List<TestEntity> test04() {
        return retrofitTest.getList(1,7);
    }

    @Override
    public void test05() {
        retrofitTest.header("JAVA");
    }
}
