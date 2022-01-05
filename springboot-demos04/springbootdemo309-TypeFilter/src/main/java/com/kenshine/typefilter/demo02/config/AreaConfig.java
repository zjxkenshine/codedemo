package com.kenshine.typefilter.demo02.config;

import com.kenshine.typefilter.demo02.AreaSpringExcludeTypeFilter;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

import java.awt.*;

/**
 * @author ：kenshine
 * @date ：Created in 2022/1/5 9:27
 * @description：
 * @modified By：
 * @version: $
 */
@Configuration
@ComponentScans(
        value = {
                @ComponentScan(value = "com.kenshine.typefilter.demo02",
//                includeFilters = {
//                        @ComponentScan.Filter(type = FilterType.ANNOTATION,classes = {Component.class}),
//                },
                excludeFilters = {
                        @ComponentScan.Filter(type = FilterType.CUSTOM,classes = {AreaSpringExcludeTypeFilter.class}),
                },useDefaultFilters = true)
        }
)
public class AreaConfig {
}
