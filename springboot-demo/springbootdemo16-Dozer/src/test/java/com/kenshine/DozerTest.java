package com.kenshine;

import com.github.dozermapper.core.Mapper;
import com.github.dozermapper.core.MappingException;
import com.kenshine.domain.*;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author ：kenshine
 * @date ：Created in 2021/10/26 9:34
 * @description：Dozer测试类
 * @modified By：
 * @version: $
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(classes = DozerApp.class)
public class DozerTest {

    /**
     * DozerMapper bean
     */
    @Resource
    private Mapper mapper;

    /**
     * Dozer基本使用
     */
    @Test
   public void test01() {
        UserDTO userDTO = new UserDTO();
        //日期格式需要一致
        userDTO.setUserId(1L).setUserName("kenshine").setGender("男").setUserAge(25).setEmail("kenshine@qq.com")
                .setBirthday(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));

        User user = mapper.map(userDTO, User.class);
        log.info(user.toString());

        UserDTO userDTO2 = mapper.map(user, UserDTO.class);
        log.info(userDTO2.toString());
    }


    /**
     * map-id 映射标识
     */
    @Test
    public void test02() {
        UserDTO userDTO = new UserDTO();
        userDTO.setUserId(2L).setUserName("kenshine").setGender("男").setUserAge(25).setEmail("kenshine@163.com")
                .setBirthday(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        //使用 map-id 为user的映射
        User user = mapper.map(userDTO, User.class, "user");
        log.info(user.toString());
    }

    /**
     * 直接指定要转换的对象而不是用User.class
     */
    @Test
    public void test03() {
        UserDTO userDTO = new UserDTO();
        userDTO.setUserId(3L).setUserName("kenshine").setGender("男").setUserAge(25).setEmail("kenshine@163.com")
                .setBirthday(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        User user = new User();
        mapper.map(userDTO, user, "user");
        log.info(user.toString());
    }

    /**
     * 排除Email属性
     */
    @Test
    public void test04() {
        UserDTO userDTO = new UserDTO();
        userDTO.setUserId(4L).setUserName("kenshine").setGender("男").setUserAge(25).setEmail("kenshine@163.com")
                .setBirthday(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        User user = mapper.map(userDTO, User.class, "user-exclude");
        log.info(user.toString());
    }

    /**
     * 单向映射
     * 逆向映射抛出MappingException异常
     */
    @Test(expected = MappingException.class)
    public void test05() {
        UserDTO userDTO = new UserDTO();
        userDTO.setUserId(5L).setUserName("kenshine").setGender("男").setUserAge(25).setEmail("kenshine@163.com")
                .setBirthday(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));

        User user = mapper.map(userDTO, User.class, "user-oneway");
        log.info(user.toString());

        UserDTO userDTO2 = mapper.map(user, UserDTO.class, "user-oneway");
        log.info(userDTO2.toString());
    }

    /**
     * 测试嵌套转换
     */
    @Test
    public void test06() {
        OrderDTO orderDTO = new OrderDTO();
        UserDTO userDTO = new UserDTO().setUserId(6L).setUserName("qin").setGender("女").setUserAge(25)
                .setEmail("diaochan@xxx.com").setBirthday("1997-02-20 23:10:36");
        orderDTO.setOrderId(1L).setOrderNumber("78956328").setOrderDescription("车车").setUserDTO(userDTO);

        Order order = mapper.map(orderDTO, Order.class, "order");
        log.info(order.toString());

        OrderDTO orderDTO2 = mapper.map(order, OrderDTO.class, "order");
        log.info(orderDTO2.toString());
    }

    /**
     * Dozer还可以对深层属性进行映射，即深度映射。例如一个对象中的String类型属性可以与另一个对象中嵌套的对象的属性进行映射
     */
    @Test
    public void test07() {
        UserInfo userInfo = new UserInfo();
        userInfo.setGender("男").setEmail("kenshine@xxx.com").setBirthday("1997-05-12 18:05:32");
        UserInfoDTO userInfoDTO = new UserInfoDTO();
        userInfoDTO.setUserId(1L).setUserName("kenshine").setUserAge(25).setUserInfo(userInfo);

        User user = mapper.map(userInfoDTO, User.class, "user-deep-mapping");
        log.info(user.toString());
    }

    /**
     * @mapping 注解简单映射测试
     */
    @Test
    public void test08() {
        UserEntity userEntity = new UserEntity();
        userEntity.setId(1L).setName("kenshine").setGender("男").setAge(25).setEmail("kenshine@xxx.com")
                .setBirthday("2001-8-18 00:00:00");
        UserVO userVO = mapper.map(userEntity, UserVO.class);
        log.info(userVO.toString());
    }


    /**
     * @mapping 自定义转换器测试
     */
    @Test
    public void test09() {
        User user = new User();
        user.setId(1L).setName("kenshine").setGender("男").setAge(25).setEmail("kenshine@xxx.com")
                .setBirthday(LocalDateTime.now());
        UserVO userVO = mapper.map(user, UserVO.class);
        log.info(userVO.toString());

        User user2 = mapper.map(userVO, User.class);
        log.info(user2.toString());
    }













}
