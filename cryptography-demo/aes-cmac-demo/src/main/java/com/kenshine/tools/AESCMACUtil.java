package com.kenshine.tools;


import javax.crypto.*;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

/**
 * @author Kenshine
 * AES-CMAC加密工具类
 */
public class AESCMACUtil {

    /**
     * 算法逻辑（使用这个方法）
     * @param key
     * @param data
     * @return
     */
    public static byte[] Aes_Cmac01(byte[] key, byte[] data){
        // 子密钥生成
        // 步骤1，将具有密钥K的AES-128应用于全零输入块。
        byte[] L = AesEncrypt(key, new byte[16], new byte[16]);

        // 步骤2，通过以下操作得出K1：
        //如果L的最高有效位等于0，则K1是L的左移1位。
        byte[] FirstSubkey = Rol(L);
        if ((L[0] & 0x80) == 0x80) {
            // 否则，K1是const_Rb的异或和L左移1位。
            FirstSubkey[15] ^= 0x87;
        }

        // 步骤3，通过以下操作得出K2：
        //如果K1的最高有效位等于0，则K2是K1左移1位
        byte[] SecondSubkey = Rol(FirstSubkey);
        if ((FirstSubkey[0] & 0x80) == 0x80) {
            // 否则，K2是const_Rb的异或，且K1左移1位
            SecondSubkey[15] ^= 0x87;
        }


        // MAC 计算
        if (((data.length != 0) && (data.length % 16 == 0)) == true) {
            //如果输入消息块的大小等于块大小（128位）
            // 最后一个块在处理之前应与K1异或
            for (int j = 0; j < FirstSubkey.length; j++){
                data[data.length - 16 + j] ^= FirstSubkey[j];
            }

        } else {
            // 否则，最后一个块应填充10 ^ i
            byte[] padding = new byte[16 - data.length % 16];
            padding[0] = (byte) 0x80;
            byte[] newData=new byte[data.length+padding.length];
            System.arraycopy(data,0,newData,0,data.length);
            System.arraycopy(padding,0,newData,data.length,padding.length);
            //   data = data.Concat<byte>(padding.AsEnumerable()).ToArray();
            // 并与K2进行异或运算
            for (int j = 0; j < SecondSubkey.length; j++){
                newData[newData.length - 16 + j] ^= SecondSubkey[j];
            }
            data=newData;
        }
        // 先前处理的结果将是最后一次加密的输入。
        byte[] encResult = AesEncrypt(key, new byte[16], data);
        byte[] HashValue = new byte[16];
        System.arraycopy(encResult, encResult.length - HashValue.length, HashValue, 0, HashValue.length);

        return HashValue;
    }

    private static byte[] Rol(byte[] b)
    {
        byte[] r = new byte[b.length];
        byte carry = 0;

        for (int i = b.length - 1; i >= 0; i--)
        {
            short u = (short)(b[i] << 1);
            r[i] = (byte)((u & 0xff) + carry);
            carry = (byte)((u & 0xff00) >> 8);
        }
        return r;
    }

    /**
     * AES加密
     * @param keys
     * @param iv
     * @param data
     * @return
     */
    private static byte[] AesEncrypt(byte[] keys, byte[] iv, byte[] data)  {
        try {
            //1.根据字节数组生成AES密钥
            SecretKey key=new SecretKeySpec(keys, "AES");
            //2.根据指定算法AES自成密码器 "算法/模式/补码方式"
            Cipher cipher = Cipher.getInstance("AES/CBC/NoPadding");
            //3.CBC模式需要向量vi
            IvParameterSpec ivps = new IvParameterSpec(iv);
            //4.初始化密码器，第一个参数为加密(Encrypt_mode)或者解密解密(Decrypt_mode)操作，第二个参数为使用的KEY
            cipher.init(Cipher.ENCRYPT_MODE, key,ivps);
            //5.获取加密内容的字节数组(这里要设置为utf-8)不然内容中如果有中文和英文混合中文就会解密为乱码
            byte [] byte_encode=data;
            //6.根据密码器的初始化方式--加密：将数据加密
            byte [] byte_AES=cipher.doFinal(byte_encode);
            //7.返回
            return byte_AES;

        } catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException | IllegalBlockSizeException | BadPaddingException | InvalidAlgorithmParameterException e) {
            e.printStackTrace();
        }

        return null;
    }

    /**
     * 计算Cmac(C#改的方法)
     * @param mixBxBuffer 数据载荷校验B0，否则为null
     * @param buffer 待校验内容
     * @param key 待加密的秘钥
     * @return
     */
    public static byte[] Aes_Cmac02(byte[] mixBxBuffer,byte[] key, byte[] buffer) {
        int bufferSize=buffer.length;
        AesCmacCtx ctx = new AesCmacCtx();
        AES_CMAC_Init(ctx);

        if (mixBxBuffer != null && mixBxBuffer.length > 0) {
            AES_CMAC_Update(ctx, mixBxBuffer, key, 16);
        }
        AES_CMAC_Update(ctx, buffer, key, bufferSize);

        return AES_CMAC_Final(ctx, key);
    }

    private static void AES_CMAC_Init(AesCmacCtx ctx) {
        ctx.X = new byte[16];
        ctx.M_n = 0;
        ctx.M_last = new byte[16];
    }

    private static void LSHIFT(byte[] v, byte[] r) {
        for (int i = 0; i < 15; i++)
        {
            r[i] = (byte)((v[i] << 1) | (v[i + 1] >> 7));
        }
        r[15] = (byte)(v[15] << 1);
    }

    private static void XOR(byte[] v, byte[] r) {
        for (int i = 0; i < 16; i++)
        {
            r[i] = (byte)(r[i] ^ v[i]);
        }
    }

    private static void AES_CMAC_Update(AesCmacCtx ctx, byte[] data, byte[] appKey, int len) {
        int mlen = 0;
        byte[] tempIn = new byte[16];
        byte[] tempData;

        if (ctx.M_n > 0) {
            mlen = Math.min(16 - ctx.M_n, len);
            for (int i = 0; i < mlen; i++) {
                ctx.M_last[ctx.M_n + i] = data[i];
            }
            ctx.M_n += mlen;
            if (ctx.M_n < 16 || len == mlen){
                return;
            }
            XOR(ctx.M_last, ctx.X);

            System.arraycopy(ctx.X,0, tempIn,0, 16);
            tempIn = AesEncrypt(appKey, new byte[16], tempIn);
            System.arraycopy(tempIn,0, ctx.X,0, 16);

            tempData = new byte[data.length - mlen];
            System.arraycopy(data, mlen, tempData, 0, data.length - mlen);
            data = new byte[data.length - mlen];
            System.arraycopy(tempData,0, data,0, tempData.length);

            len -= mlen;
        }
        while (len > 16) {
            XOR(data,ctx.X);

            System.arraycopy(ctx.X, 0, ctx.X,0,16);
            tempIn = AesEncrypt(appKey, new byte[16], tempIn);
            System.arraycopy(tempIn,0, ctx.X,0, 16);

            tempData = new byte[data.length - 16];
            System.arraycopy(data, 16, tempData, 0, data.length - 16);
            data = new byte[data.length - 16];
            System.arraycopy(tempData, 0,data,0, tempData.length);

            len -= 16;
        }
        System.arraycopy(data,0, ctx.M_last,0, len);
        ctx.M_n = len;
    }

    /**
     * 返回cmac
     * @return
     */
    private static byte[] AES_CMAC_Final(AesCmacCtx ctx, byte[] appKey){
        byte[] Cmac = new byte[16];
        byte[] tempK = new byte[16];
        byte[] tempIn = new byte[16];

        tempK = AesEncrypt(appKey, new byte[16], tempK);


        if ((tempK[0] & 0x80) > 0) {
            LSHIFT(tempK, tempK);
            tempK[15] ^= 0x87;
        }else{
            LSHIFT(tempK, tempK);
        }
        if (ctx.M_n == 16) {
            XOR(tempK, ctx.M_last);
        } else {
            if ((tempK[0] & 0x80) > 0) {
                LSHIFT(tempK, tempK);
                tempK[15] ^= 0x87;
            }else{
                LSHIFT(tempK, tempK);
            }

            ctx.M_last[ctx.M_n] = (byte)0x80;
            while (++ctx.M_n < 16) {
                ctx.M_last[ctx.M_n] = 0x00;
            }
            XOR(tempK, ctx.M_last);
        }
        XOR(ctx.M_last, ctx.X);

        System.arraycopy(ctx.X,0, tempIn, 0,16);
        tempIn = AesEncrypt(appKey, new byte[16], tempIn);
        // tempK = new byte[16];
        System.arraycopy(tempIn,0, Cmac, 0,16);

        return Cmac;
    }

}

