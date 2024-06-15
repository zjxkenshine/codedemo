package com.kenshine.mapstructplus.controller;

import com.kenshine.mapstructplus.model.test01.User;
import com.kenshine.mapstructplus.model.test01.UserDto;
import com.kenshine.mapstructplus.model.test02.Car;
import com.kenshine.mapstructplus.model.test02.CarDto;
import com.kenshine.mapstructplus.model.test02.SeatConfiguration;
import io.github.linpeilie.Converter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author by kenshine
 * @Classname TestController
 * @Description 测试转换
 * @Date 2024-06-15 8:56
 * @modified By：
 * @version: 1.0$
 */
@RestController
public class TestController {
    @Resource
    private Converter converter;

    /**
     * localhost:8080/test01
     */
    @GetMapping("/test01")
    public void test01(){
        User user = new User();
        user.setUsername("kenshine");
        user.setAge(23);
        user.setYoung(false);

        UserDto userDto = converter.convert(user, UserDto.class);
        System.out.println(userDto);

        assert user.getUsername().equals(userDto.getUsername());
        assert user.getAge() == userDto.getAge();
        assert user.isYoung() == userDto.isYoung();

        User newUser = converter.convert(userDto, User.class);
        System.out.println(newUser);

        assert user.getUsername().equals(newUser.getUsername());
        assert user.getAge() == newUser.getAge();
        assert user.isYoung() == newUser.isYoung();
    }


    /**
     * 自定义类型转换
     * localhost:8080/test02
     */
    @GetMapping("/test02")
    public void test02(){
        SeatConfiguration seatConfiguration = new SeatConfiguration().setName("真皮座椅").setPrice(5000);
        Car car = new Car().setName("宝马").setType("小轿车").setSeatConfiguration(seatConfiguration);
        CarDto carDto = this.converter.convert(car, CarDto.class);
        System.out.println("carDto = " + carDto);
    }


}
