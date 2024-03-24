package com.kenshine.jacksonxml;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

/**
 * JacksonXmlElementWrapper 包装
 * @author kenshine
 */
@Data
@AllArgsConstructor
public class Wrapper {
    @JacksonXmlElementWrapper(localName = "list")
    // @JacksonXmlElementWrapper(useWrapping = false) 不使用包装
    private List<String> names;
}