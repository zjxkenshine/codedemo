package com.kenshine.mapstruct.mapper;

import com.kenshine.mapstruct.domain.demo3.AddPassagewayParam;
import com.kenshine.mapstruct.domain.demo3.SmsPassageway;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 * @author ：kenshine
 * @date ：Created in 2021/11/28 11:07
 * @description：
 * @modified By：
 * @version: $
 * 将map映射为json str
 * 表达式映射
 */
@Mapper(componentModel = "spring")
public interface SmsPassagewayMap {

    @Mapping(target = "accessMsg", expression = "java(com.kenshine.mapstruct.utils.Json.MapToJson(addPassagewayParam.getAccessMap()))")
    SmsPassageway addPassagewayParam2SmsPassageway(AddPassagewayParam addPassagewayParam);
}
