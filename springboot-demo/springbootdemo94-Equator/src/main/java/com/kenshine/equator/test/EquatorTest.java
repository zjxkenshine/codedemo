package com.kenshine.equator.test;

import com.github.dadiyang.equator.Equator;
import com.github.dadiyang.equator.FieldInfo;
import com.github.dadiyang.equator.GetterBaseEquator;
import com.kenshine.equator.domain.User;
import com.kenshine.equator.domain.UserDTO;

import java.util.List;

/**
 * @author ：kenshine
 * @date ：Created in 2021/11/17 10:09
 * @description：测试
 * @modified By：
 * @version: $
 */
public class EquatorTest {

    public static void main(String[] args) {
        Equator equator = new GetterBaseEquator();
        // 支持比对两个不同类型的对象，默认只比对两个类字段的交集，即两个类都有的字段才比对
        User user1 = new User().setId(123L).setName("kenshine").setPassword("123123");
        UserDTO user2 = new UserDTO().setId(456L).setName("kenshine").setPassword("666666");

        // 判断属性是否完全相等
        System.out.println(equator.isEquals(user1, user2));

        // 获取不同的属性
        List<FieldInfo> diff = equator.getDiffFields(user1, user2);
        System.out.println(diff);
    }

}
