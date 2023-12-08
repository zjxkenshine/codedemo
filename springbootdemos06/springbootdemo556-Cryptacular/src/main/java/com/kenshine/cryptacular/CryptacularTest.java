package com.kenshine.cryptacular;

import org.bouncycastle.crypto.BlockCipher;
import org.bouncycastle.crypto.engines.AESEngine;
import org.bouncycastle.crypto.modes.AEADBlockCipher;
import org.bouncycastle.crypto.modes.GCMBlockCipher;
import org.cryptacular.CryptoException;
import org.cryptacular.EncodingException;
import org.cryptacular.SaltedHash;
import org.cryptacular.StreamException;
import org.cryptacular.bean.*;
import org.cryptacular.codec.Base64Decoder;
import org.cryptacular.codec.Base64Encoder;
import org.cryptacular.codec.Decoder;
import org.cryptacular.codec.Encoder;
import org.cryptacular.generator.Nonce;
import org.cryptacular.generator.SecretKeyGenerator;
import org.cryptacular.generator.sp80038a.RBGNonce;
import org.cryptacular.io.DecodingInputStream;
import org.cryptacular.io.EncodingOutputStream;
import org.cryptacular.io.FileResource;
import org.cryptacular.spec.AEADBlockCipherSpec;
import org.cryptacular.spec.BufferedBlockCipherSpec;
import org.cryptacular.spec.CodecSpec;
import org.cryptacular.spec.DigestSpec;
import org.cryptacular.util.*;
import org.junit.Test;

import javax.crypto.SecretKey;
import java.io.*;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.security.KeyStore;

/**
 * @author by kenshine
 * @Classname CryptacularTest
 * @Description Cryptacular使用
 * @Date 2023-12-08 16:05
 * @modified By：
 * @version: 1.0$
 */
public class CryptacularTest {

    /**
     * 加密文件
     * 使用与Bouncy Castle相似的api
     */
    @Test
    public void test01() throws FileNotFoundException {
        AEADBlockCipher cipher = new GCMBlockCipher(new AESEngine());
        SecretKey key = SecretKeyGenerator.generate(cipher.getUnderlyingCipher());
        File file = new File("file\\test.txt");
        OutputStream tempOut = new FileOutputStream("file\\test_enc.txt");
        CipherUtil.encrypt(cipher, key, new RBGNonce(), StreamUtil.makeStream(file), tempOut);
    }

    /**
     * 可以有效避免密码学常见错误
     */
    @Test
    public void test02(){
        // Cryptacular强制使用动态IV进行加密，并使IV的存储安全，便于解密
        BufferedBlockCipherBean cipherBean = new BufferedBlockCipherBean();
        // 描述分组密码 algorithm/mode/padding
        // mode CBC/OFB/CFB 分组密码工作模式
        // padding ISO7816d4/ISO7816/ISO10126/ISO10126-2/PKCS7/PKCS5/TBC/X923/NULL/Zero/None
        String cipherSpecString = "AES/CBC/Zero";
        BufferedBlockCipherSpec cipherSpec = BufferedBlockCipherSpec.parse(cipherSpecString);
        // 设置nonce/IV生成策略
        cipherBean.setNonce(new RBGNonce());
        // 别名
        cipherBean.setKeyAlias("vtcrypt");
        // 密码
        cipherBean.setKeyPassword("vtcrypt");
        // 设置包含加密/解密密钥的密钥存储库
        cipherBean.setKeyStore(getTestKeyStore());
        cipherBean.setBlockCipherSpec(cipherSpec);
        // 加密
        byte[] ciphertext = cipherBean.encrypt(ByteUtil.toBytes(123456));
    }

    /**
     * 加密字符串
     */
    @Test
    public void test03(){
        EncodingHashBean bean = new EncodingHashBean();
        bean.setDigestSpec(new DigestSpec("SHA-256"));
        bean.setCodecSpec(CodecSpec.HEX);
        bean.setIterations(5);
        // 随机数生成策略
        Nonce saltSource = new RBGNonce(8);
        String hexHash = bean.hash("password", saltSource.generate());
        System.out.println(hexHash);
    }

    /**
     * HashUtil 快速加密工具类
     */
    @Test
    public void test04(){
        // 快速操作
        byte[] hash = HashUtil.sha1("Some text");
        System.out.println(new String(hash));
        // 处理流数据
        byte[] hash1 = HashUtil.sha1(StreamUtil.makeStream(new File("file/test.txt")));
        System.out.println(new String(hash1));
    }

    /**
     * 常见hash操作
     */
    @Test
    public void test05() throws FileNotFoundException {
        byte[] sha1Bytes = HashUtil.sha1("Codito ergo sum");
        String sha256Hex = CodecUtil.hex(HashUtil.sha256("Ecce homo"));
        System.out.println(sha256Hex);
        byte[] sha256Bytes = HashUtil.sha256(new FileInputStream("file/test.txt"));
    }

    /**
     *密码身份验证流程
     * 密码比对
     */
    @Test
    public void test06(){
        // saltedhash算法
        SaltedHash authoritativeHash = new SaltedHash(
                // 加密的数据
                CodecUtil.b64("9b0483b9cc42d7bac6084ae4443684745c52e8abbf892c125939a98ee38eb954"),
                // SHA-1哈希值是160位/20字节长
                20,
                // Salt被附加到哈希字节的末尾
                true);

        // 执行哈希比较
        boolean areEqual = HashUtil.compareHash(
                // hash算法
                new org.bouncycastle.crypto.digests.SHA1Digest(),
                // 加盐哈希数据
                authoritativeHash,
                1,
                // 盐被加到最后
                true,
                // 要散列的数据 不包含盐值
                "password");
        System.out.println(areEqual);
    }


    /**
     * 加解密流程
     * java.nio.BufferOverflowException
     */
    @Test
    public void test07() throws IOException {
        // 定义用于加密/解密的底层AES密码
        BlockCipher block = new org.bouncycastle.crypto.engines.AESEngine();

        // 将底层AES分组密码封装在GCM模式密码中
        AEADBlockCipher aeadCipher = new org.bouncycastle.crypto.modes.GCMBlockCipher(block);

        // 生成一个新的128位AES密钥，但是可以从Keystore或其他安全存储中加载一个密钥
        SecretKey key = SecretKeyGenerator.generate(128, block);

        // Nonce类
        // org.cryptacular.generator.sp80038d.RBGNonce - AEAD-mode ciphers
        // org.cryptacular.generator.sp80038a.RBGNonce - block mode (e.g. CBC) ciphers
        Nonce nonce = new org.cryptacular.generator.sp80038d.RBGNonce();

        //============
        // 加密
        //============
        // 围绕原始明文输入创建输入流进行加密
        InputStream inPlain = new FileInputStream("file\\test.txt");

        // 创建将保存base64编码的密文的文件的输出流
        OutputStream outCipher = new EncodingOutputStream(
                new FileOutputStream("file\\cipher.b64"),
                // 每行72个字符换行
                new Base64Encoder());

        // 执行加密
        CipherUtil.encrypt(aeadCipher, key, nonce, inPlain, outCipher);
        outCipher.close();

        //============
        // 解密
        //============
        // 创建围绕密文输入的输入流,必须处理base64解码
        InputStream inCipher = new DecodingInputStream(
                new FileInputStream("file\\cipher.b64"),
                new Base64Decoder());

        // 创建输出流以保存解密的明文 Encoder即时编码的编码器
        //OutputStream outPlain = new EncodingOutputStream(new FileOutputStream("file\\test07.txt"),new Base64Encoder());
        OutputStream outPlain = new FileOutputStream("file\\test07.txt");
        // 执行解密 java.nio.BufferOverflowException
        CipherUtil.decrypt(aeadCipher, key, inCipher, outPlain);
    }


    /**
     * Beans 常用配置组件 bean
     * org.cryptacular.EncodingException: Bad ciphertext header
     */
    @Test
    public void test08(){
        AEADBlockCipherSpec aeadBlockCipherSpec = new AEADBlockCipherSpec("AES","GCM");
        RBGNonce rbgNonce = new RBGNonce(8);
        KeyStore keyStore = getTestKeyStore();
        // 初始化CipherBean
        CipherBean cipherBean = new AEADBlockCipherBean(aeadBlockCipherSpec,
                keyStore,
                "vtcrypt",
                "vtcrypt",
                rbgNonce
        );
        String encrypt = new String(cipherBean.encrypt(ByteUtil.toBytes("test")));
        System.out.println(encrypt);
        String decrypt = ByteUtil.toString(cipherBean.decrypt(encrypt.getBytes()));
        System.out.println(decrypt);
    }



    /**
     * 获取keystore 用于加密密钥和证书的存储设施
     */
    private KeyStore getTestKeyStore() {
        final KeyStoreFactoryBean bean = new KeyStoreFactoryBean();
        bean.setPassword("vtcrypt");
        bean.setResource(new FileResource(new File("file\\cipher-bean.jceks")));
        // JKS, JCEKS, BKS...默认为JCEKS
        bean.setType("JCEKS");
        return bean.newInstance();
    }
}
