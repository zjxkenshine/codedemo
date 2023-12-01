package com.kenshine.smartlicense;

import org.apache.commons.io.IOUtils;
import org.junit.Test;
import org.smartboot.license.client.License;
import org.smartboot.license.client.LicenseEntity;
import org.smartboot.license.client.Md5;
import org.smartboot.license.server.LicenseEncode;
import org.smartboot.license.server.LicenseServer;
import org.smartboot.license.server.RasUtil;
import org.smartboot.license.server.SourceLicense;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.security.KeyPair;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Date;
import java.util.Properties;

/**
 * @author by kenshine
 * @Classname LicenseTest
 * @Description 授权测试
 * @Date 2023-12-01 16:56
 * @modified By：
 * @version: 1.0$
 */
public class LicenseTest {

    /**
     * 秘钥对生成
     */
    @Test
    public void test00() throws Exception {
        KeyPair keyPair = RasUtil.initKey();
        String publicKey = "publicKey: " + Base64.getEncoder().encodeToString(RasUtil.getPublicKey(keyPair));
        String privateKey = "privateKey: " + Base64.getEncoder().encodeToString(RasUtil.getPrivateKey(keyPair));
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("--------- ").append(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date())).append(" ---------");
        stringBuilder.append(System.lineSeparator());
        stringBuilder.append(publicKey);
        stringBuilder.append(System.lineSeparator());
        stringBuilder.append(System.lineSeparator());
        stringBuilder.append(privateKey);
        stringBuilder.append(System.lineSeparator());
        stringBuilder.append("--------- END ---------");
        stringBuilder.append(System.lineSeparator());
        System.out.println(stringBuilder);
        FileOutputStream fileOutputStream = new FileOutputStream("src/main/resources/keystore.txt", true);
        fileOutputStream.write(stringBuilder.toString().getBytes());
        fileOutputStream.close();
    }

    /**
     * 生成授权文件 无秘钥
     * 生成License的时候，传入私钥参数进行文件加密
     */
    @Test
    public void test01() throws Exception {
        // 生成源文件地址
        String SOURCE_FILE="src/main/resources/source.txt";
        // 生成授权文件地址
        String LICENSE_FILE="src/main/resources/license.txt";

        LicenseServer license = new LicenseServer(new File(SOURCE_FILE), new File(LICENSE_FILE));
        // 过期时间
        String expire = "2023-12-30";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date expireDate = sdf.parse(expire);
        // 从文件输入内容
        String filePath = null;
        // 内容
        String text = "kenshine";
        // 私钥
        String key = null;
        byte[] keyBytes = null;
        if (key != null) {
            try {
                keyBytes = Base64.getDecoder().decode(key);
            } catch (Exception e) {
                System.out.println("PrivateKey decode fail: " + e.getMessage());
                return;
            }
        }

        byte[] bytes;
        if (filePath != null) {
            File file = new File(filePath);
            if (!file.isFile()) {
                System.out.println("none file:" + file.getAbsolutePath());
                return;
            }
            System.out.println("sign for file:" + file.getPath());
            bytes = IOUtils.toByteArray(new FileInputStream(file));
        } else {
            if (text == null) {
                System.out.println("none text");
                return;
            }
            System.out.println("sign for string:" + text);
            bytes = text.getBytes();
        }
        if (keyBytes != null) {
            license.createLicense(bytes, expireDate, keyBytes);
        } else {
            license.createLicense(bytes, expireDate);
        }
    }


    /**
     * 根据源文件恢复授权文件
     */
    @Test
    public void test02() throws Exception {
        String source="src/main/resources/source.txt";
        File file = new File(source);
        if (file.isFile()) {
            createLicense(new FileInputStream(file));
        } else {
            System.err.println("file " + file.getAbsolutePath() + " is not exists");
        }
    }

    /**
     * 授权文件校验
     * 加载解析License时传入公钥进行解密，强烈建议将公钥硬编码至项目代码中
     */
    @Test
    public void test03(){
        InputStream inputStream = LicenseTest.class.getClassLoader().getResourceAsStream("license1.txt");
        License license = new License();
        LicenseEntity licenseData = license.loadLicense(inputStream);
        //LicenseEntity licenseData = license.loadLicense(inputStream,Base64.getDecoder().decode("公钥"));
        System.out.println(new String(licenseData.getData()));
    }

    /**
     * 生成授权文件
     */
    private void createLicense(InputStream inputStream) throws IOException, ParseException {
        Properties properties = new Properties();
        properties.load(inputStream);
        String expireTime = properties.getProperty(SourceLicense.PROPERTY_EXPIRE_DATE);
        Base64.Decoder decoder = Base64.getDecoder();
        byte[] content = decoder.decode(properties.getProperty(SourceLicense.PROPERTY_BASE64_CONTENT));
        byte[] publicKey = decoder.decode(properties.getProperty(SourceLicense.PROPERTY_PUBLIC_KEY));
        byte[] privateKey = decoder.decode(properties.getProperty(SourceLicense.PROPERTY_PRIVATE_KEY));
        SimpleDateFormat sdf = new SimpleDateFormat(SourceLicense.DATE_FORMAT);
        LicenseEntity licenseEntity = new LicenseEntity(sdf.parse(expireTime).getTime(), publicKey, Md5.md5(content));
        licenseEntity.setData(content);

        //生成License
        File file = new File("src/main/resources/license_revert.txt");
        try (FileOutputStream fileOutputStream = new FileOutputStream(file)) {
            LicenseEncode licenseEncode = new LicenseEncode();
            fileOutputStream.write(Base64.getEncoder().encodeToString(licenseEncode.encode(licenseEntity, privateKey)).getBytes(StandardCharsets.UTF_8));
        }
    }

    private void loadLicense(Properties properties) {
        // 初始化 License 客户端。
        License license = new License();
        // 加载 License 文件流。
        try (InputStream inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("License.shield")) {
            // 解析 License 进行合法性校验，并获取授权内容。
            LicenseEntity entity = license.loadLicense(inputStream);
            // 基于授权内容进行软件运行时配置初始化。
            properties.load(new ByteArrayInputStream(entity.getData()));
            System.out.println(properties);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
