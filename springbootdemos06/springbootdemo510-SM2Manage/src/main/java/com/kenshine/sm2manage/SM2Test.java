package com.kenshine.sm2manage;

import com.kenshine.sm2.domain.CurveABBO;
import com.kenshine.sm2.domain.PubAndPriKeysBO;
import com.kenshine.sm2.domain.RespVO;
import com.kenshine.sm2.domain.TemporaryPubKeyBO;
import com.kenshine.sm2.util.SM2Util;
import org.junit.Test;

import java.math.BigInteger;
import java.security.spec.ECGenParameterSpec;

/**
 * @author by kenshine
 * @Classname SM2Test
 * @Description 秘钥申请测试
 * @Date 2023-11-28 9:56
 * @modified By：
 * @version: 1.0$
 */
public class SM2Test {


    @Test
    public void test(){
        RespVO respVO=generate("A","secp384r1");
        System.out.println(respVO);

        RespVO respVO1=generate("B","secp521r1");
        System.out.println(respVO1);
    }


    /**
     *
     * @param order A：甲生成乙 B：乙生成甲
     * @param name 椭圆曲线名称
     * secp384r1
     * secp521r1
     * secp256k1
     * secp256r1
     * secp521r1
     *
     * @return
     */
    private RespVO generate(String order,String name){
        RespVO respVO = new RespVO();
        try {
            //初始化椭圆曲线
            ECGenParameterSpec curve = SM2Util.generateCurve(name);
            //计算椭圆ab点
            CurveABBO curveAB = SM2Util.getCurveAB(curve);
            //甲乙方生成密钥对(公钥和私钥)
            PubAndPriKeysBO pubAndPriKeysBO = SM2Util.generateKeys(curve);
            //甲方生成临时公钥
            TemporaryPubKeyBO keyBO_A =
                    SM2Util.generateTemporaryPubKey(pubAndPriKeysBO.getPrivateKeyA(), pubAndPriKeysBO.getPublicKeyB());
            //乙方生成临时公钥
            TemporaryPubKeyBO keyBO_B =
                    SM2Util.generateTemporaryPubKey(pubAndPriKeysBO.getPrivateKeyB(), pubAndPriKeysBO.getPublicKeyA());
            //生成对称秘钥 以甲生成乙/以乙生成甲
            BigInteger symmetricKey = null;
            if ("A".equals(order)){
                symmetricKey = SM2Util.generateSymmetricKey(pubAndPriKeysBO.getPrivateKeyA(), pubAndPriKeysBO.getPublicKeyB(), keyBO_A.getKeyByte());
            }
            if ("B".equals(order)){
                symmetricKey = SM2Util.generateSymmetricKey(pubAndPriKeysBO.getPrivateKeyB(), pubAndPriKeysBO.getPublicKeyA(),keyBO_B.getKeyByte());
            }

            respVO.setCurA(curveAB.getA());
            respVO.setCurB(curveAB.getB());
            respVO.setAPersonalKey(pubAndPriKeysBO.getPrivateKeyA().getS().toString());
            respVO.setAPublicKey(keyBO_A.getKey().toString());
            respVO.setBPersonalKey(pubAndPriKeysBO.getPrivateKeyB().getS().toString());
            respVO.setBPublicKey(keyBO_B.getKey().toString());
            respVO.setSymmetricSecretKey(symmetricKey.toString());
        }catch (Exception e){
            e.printStackTrace();
        }
        return respVO;
    }
}
