package com.kenshine.mapstruct.mapper;

import org.mapstruct.MapMapping;
import org.mapstruct.Mapper;

import java.util.Date;
import java.util.Map;

/**
 * @author ：kenshine
 * @date ：Created in 2021/11/28 11:05
 * @description：
 * @modified By：
 * @version: $
 */
@Mapper(componentModel = "spring")
public interface SourceTargetMapper {
    /**
     * 映射Map
     */
    @MapMapping(valueDateFormat = "dd.MM.yyyy")
    Map<String, String> longDateMapToStringStringMap(Map<Long, Date> source);

}
