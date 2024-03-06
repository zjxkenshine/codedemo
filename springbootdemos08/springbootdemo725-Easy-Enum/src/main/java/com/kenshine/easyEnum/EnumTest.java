package com.kenshine.easyEnum;

import com.robot.dict.Dict;
import com.robot.dict.DictBean;
import org.junit.Test;

import java.util.List;

/**
 * @author by kenshine
 * @Classname EnumTest
 * @Description Dict接口使用示例
 * @Date 2024-03-06 8:17
 * @modified By：
 * @version: 1.0$
 */
public class EnumTest {
    /**
     * 获取枚举信息
     */
    @Test
    public void test01(){
        Integer code = SexEnum.MALE.getCode();
        String text = SexEnum.MALE.getText();
        System.out.println(code);
        System.out.println(text);
    }

    /**
     * 枚举查询
     */
    @Test
    public void test02(){
        // 1、通过code获取text
        String text = Dict.getTextByCode(SexEnum.class, 1); // "男"
        // 2、通过text获取code
        Integer code = Dict.getCodeByText(SexEnum.class, "男"); // 1
        // 3、通过code获取枚举
        SexEnum sex = Dict.getByCode(SexEnum.class, 1); // SexEnum.MALE
        System.out.println(text);
        System.out.println(code);
        System.out.println(sex);
    }

    /**
     * 转换为字典项集合
     */
    @Test
    public void test03(){
        // 4、获取枚举的所有元素
        List<DictBean> all = Dict.getAll(SexEnum.class); // [{code:1,text:"男"},{code:2,text:"女"},{code:3,text:"未知"}]
        // 5、获取枚举的指定元素
        List<DictBean> items = Dict.getItems(SexEnum.MALE, SexEnum.FEMALE); // [{code:1,text:"男"},{code:2,text:"女"}]
        // 6、排除指定元素，获取其他元素
        List<DictBean> items1 = Dict.getItemsExclude(SexEnum.UNKNOWN); // [{code:1,text:"男"},{code:2,text:"女"}]
        System.out.println(all);
        System.out.println(items);
        System.out.println(items1);
    }

    /**
     * @Deprecated 枚举过期
     */
    @Test
    public void test04(){
        // 第二个参数表示是否排除废弃选项
        List<DictBean> all = Dict.getAll(SexEnum.class, true); // [{code:1,text:"男"},{code:2,text:"女"}]
        System.out.println(all);
    }
}
