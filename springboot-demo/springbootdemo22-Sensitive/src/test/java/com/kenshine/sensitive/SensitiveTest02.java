package com.kenshine.sensitive;

import com.github.houbb.deep.copy.fastjson.FastJsonDeepCopy;
import com.github.houbb.hash.core.core.hash.Hashes;
import com.github.houbb.sensitive.core.api.SensitiveUtil;
import com.github.houbb.sensitive.core.bs.SensitiveBs;
import com.kenshine.domain.CustomPasswordModel;
import com.kenshine.domain.User;
import com.kenshine.domain.UserAnnotationBean;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.slf4j.LoggerFactory;

/**
 * @author by kenshine
 * @Classname SensitiveTest02
 * @Description 测试
 * @Date 2023-11-10 11:33
 * @modified By：
 * @version: 1.0$
 *
 * 1.6.0版本
 */
public class SensitiveTest02 {

    /**
     * 测试Sensitive简化注解
     */
    @Test
    public void test01(){
        UserAnnotationBean bean  = new UserAnnotationBean();
        bean.setUsername("张三");
        bean.setPassword("123456");
        bean.setPassport("CN1234567");
        bean.setPhone("13066668888");
        bean.setAddress("中国上海市浦东新区外滩18号");
        bean.setEmail("whatanice@code.com");
        bean.setBirthday("20220831");
        bean.setGps("66.888888");
        bean.setIp("127.0.0.1");
        bean.setMaskAll("可恶啊我会被全部掩盖");
        bean.setMaskHalf("还好我只会被掩盖一半");
        bean.setMaskRange("我比较灵活指定掩盖范围");
        bean.setBandCardId("666123456789066");
        bean.setIdNo("360123202306018888");
        // 执行脱敏
        UserAnnotationBean sensitiveUser = SensitiveUtil.desCopy(bean);
        System.out.println(sensitiveUser.toString());
        System.out.println(bean.toString());
    }

    /**
     * 自定义脱敏注解
     */
    @Test
    public void test02() {
        CustomPasswordModel model = buildCustomPasswordModel();
        CustomPasswordModel sensitive = SensitiveUtil.desCopy(model);
        System.out.println(sensitive);
        System.out.println(model);
    }
    private CustomPasswordModel buildCustomPasswordModel() {
        return new CustomPasswordModel("hello","123456");
    }

    /**
     * 生成脱敏JSON
     */
    @Test
    public void test03(){
        CustomPasswordModel model = buildCustomPasswordModel();
        String json=SensitiveUtil.desJson(model);
        System.out.println(json);
    }

    /**
     * SensitiveBs 脱敏引导类
     *
     */
    @Test
    public void test04(){
       SensitiveBs sensitiveBs= SensitiveBs.newInstance()
               // 深度拷贝脱敏对象
                .deepCopy(FastJsonDeepCopy.getInstance())
               // HASH策略
                .hash(Hashes.md5());

        User user= new SensitiveTest01().buildUser();
        System.out.println(user);
        System.out.println(sensitiveBs.desJson(user));
        System.out.println(sensitiveBs.desCopy(user));
    }


    Logger logger= LogManager.getLogger(SensitiveTest02.class);

    /**
     * log4j2日志整合
     *
     * 指定 package 为 packages = "com.github.houbb.sensitive.log4j2.layout"
     * 按照 log4j2 layout 规范，指定 Layout 策略为 SensitivePatternLayout
     *
     * 配置
     * https://github.com/houbb/sensitive#log4j2-%E9%85%8D%E7%BD%AE%E5%AE%9A%E5%88%B6%E5%8C%96
     */
    @Test
    public void test05(){
        final String TEST_LOG = "mobile:13088887777; bankCard:6217004470007335024, email:mahuateng@qq.com, amount:123.00, " +
                "IdNo:340110199801016666, name1:李明, name2:李晓明, name3:李泽明天, name4:山东小栗旬" +
                ", birthday:20220517, GPS:120.882222, IPV4:127.0.0.1, address:中国上海市徐汇区888号;";
        logger.info(TEST_LOG);
    }


    /**
     * logback日志整合
     */
    org.slf4j.Logger logger1= LoggerFactory.getLogger(SensitiveTest02.class);
    @Test
    public void test06(){
        final String TEST_LOG = "mobile:13088887777; bankCard:6217004470007335024, email:mahuateng@qq.com, amount:123.00, " +
                "IdNo:340110199801016666, name1:李明, name2:李晓明, name3:李泽明天, name4:山东小栗旬" +
                ", birthday:20220517, GPS:120.882222, IPV4:127.0.0.1, address:中国上海市徐汇区888号;";
        logger1.info(TEST_LOG);
    }

}
