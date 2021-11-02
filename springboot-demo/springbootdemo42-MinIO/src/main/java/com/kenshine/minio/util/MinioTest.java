package com.kenshine.minio.util;

import io.minio.*;
import io.minio.errors.*;
import io.minio.http.Method;
import okhttp3.HttpUrl;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.concurrent.TimeUnit;

/**
 * @author ：kenshine
 * @date ：Created in 2021/11/2 9:27
 * @description：minio测试
 * @modified By：
 * @version: $
 *
 * 之前项目用过7.0，不多做测试了
 * 部分方法有区别
 */
public class MinioTest {

   private static final MinioClient client = MinioClient.builder().endpoint("http://127.0.0.1:9000").credentials("admin","12345678").build();


    /**
     *
     * @param args
     */
    public static void main(String[] args) throws IOException, InvalidKeyException, InvalidResponseException, InsufficientDataException, NoSuchAlgorithmException, ServerException, InternalException, XmlParserException, ErrorResponseException {


        //file上传
        ObjectWriteResponse uploaWriteResponse = client.uploadObject(
                UploadObjectArgs.builder()
                        .bucket("demo42")
                        .filename("D:\\IdeaWorkSpace\\codedemo\\springboot-demo\\springbootdemo42-MinIO\\src\\main\\resources\\img\\1.jpg")
                        .object("1A.jpg")
                        .build());
        System.out.println(uploaWriteResponse.headers());


        /**
         * 多线程下 MultipartFile 存放的临时文件路径会随主线程结束而结束
         *  需要传递InputStream对象
         */
        //流上传（Controller接收MultipartFile）
        MultipartFile file = null;
        ObjectWriteResponse objectWriteResponse = client.putObject(
                PutObjectArgs.builder()
                        .bucket("demo42")
                        .stream(file.getInputStream(), -1, 1024)
                        .object("1B.jpg")
                        .build());
        System.out.println(uploaWriteResponse.headers());


        //长链接,永久链接设置 https://blog.csdn.net/u013205984/article/details/114117019
        //获取带有过期时间的链接地址
        String objectUrl = client.getPresignedObjectUrl(GetPresignedObjectUrlArgs.builder()
                .bucket("demo42")
                .object("1A.jpg")
                .method(Method.GET)
                .expiry(30, TimeUnit.SECONDS)
                .build());
        System.out.println(objectUrl);

        //下载到本地
        client.downloadObject(DownloadObjectArgs.builder()
                .bucket("demo42")
                .object("1A.jpg")
                .filename("1A.jpg")
                .build());


        //下载写入HttpServletResponse
        HttpServletResponse response = null;
        GetObjectResponse getObjectResponse = client.getObject(GetObjectArgs.builder()
                .bucket("demo42")
                .object("1A.jpg")
                .build());
        response.setHeader("Content-Disposition", "attachment;filename=" + "1A.jpg");
        response.setContentType("application/force-download");
        response.setCharacterEncoding("UTF-8");
        IOUtils.copy(getObjectResponse, response.getOutputStream());

        /**
         * minio使用setBucketPolicy设置桶策略
         * https://blog.csdn.net/qq_43329216/article/details/119212835
         */
        client.setBucketPolicy(SetBucketPolicyArgs.builder().config("").build());
    }













}
