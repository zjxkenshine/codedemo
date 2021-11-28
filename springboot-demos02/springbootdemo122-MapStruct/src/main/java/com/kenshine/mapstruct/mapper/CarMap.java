package com.kenshine.mapstruct.mapper;

import com.kenshine.mapstruct.domain.demo2.Car;
import com.kenshine.mapstruct.domain.demo2.CarDTO;
import com.kenshine.mapstruct.domain.demo2.Person;
import com.kenshine.mapstruct.domain.demo2.PersonDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;
import java.util.Set;

/**
 * @author ：kenshine
 * @date ：Created in 2021/11/28 10:56
 * @description：
 * @modified By：
 * @version: $
 */
@Mapper(componentModel = "spring")
public interface CarMap {
    /**
     * @Mapping
     * 不同字段处理
     */
    @Mapping(source = "make", target = "manufacturer")
    @Mapping(source = "numberOfSeats", target = "seatCount")
    CarDTO carToCarDto(Car car);


    @Mapping(source = "fullname", target = "name")
    PersonDTO personToPersonDto(Person person);

    /**
     * 支持传递多个源数据
     */
    @Mapping(source = "car.make", target = "manufacturer")
    @Mapping(source = "car.numberOfSeats", target = "seatCount")
    CarDTO carToCarDto(Car car,Person person);

//    /**
//     * 手动编写
//     * @param person
//     * @return
//     */
//    default PersonDTO personToPersonDto(Person person){
//        if(Objects.isNull(person)){
//            return null;
//        }
//        PersonDTO personDTO = new PersonDTO();
//        personDTO.setName(person.getFullname());
//        personDTO.setAge(person.getAge());
//        return personDTO;
//    }

    /**
     * 更新现有实例 @MappingTarget
     */
    @Mapping(target = "make", source = "manufacturer")
    @Mapping(target = "numberOfSeats", source = "seatCount")
    void updateCarFromDto(CarDTO carDTO,@MappingTarget Car car);

    /**
     * 数字，日期 格式化
     */
//    @Mapping(target = "engine.horsePower", source = "engine.horsePower", numberFormat = "#.##E0")
//    @Mapping(target = "price", source = "price", numberFormat = "$#.00")
//    @Mapping(target = "createTime", dateFormat = "yyyy-MM-dd HH:mm:ss")
//    @Mapping(source = "make", target = "manufacturer")
//    @Mapping(source = "numberOfSeats", target = "seatCount")
//    CarDTO updateCarFromDto(Car car);


    /**
     * 映射集合
     */
    Set<String> integerSetToStringSet(Set<Integer> integers);
    List<CarDTO> carsToCarDtos(List<Car> cars);


}
