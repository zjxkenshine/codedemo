package com.kenshine.crane4j.Test07;

import cn.crane4j.core.container.Container;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author by kenshine
 * @Classname Test05Life
 * @Description 生命周期
 * @Date 2023-10-16 17:27
 * @modified By：
 * @version: 1.0$
 */
public class Test05Life {

    @Component
    @Getter
    @RequiredArgsConstructor
    public class Foo implements Container<String>, Container.Lifecycle {
        private final String namespace = "AllDictContainer";
        private final DictService dictService;
        private Map<String, DictDO> allDicts = new HashMap<>();

        @Override
        public void init() {
            // 初始化方法
            allDicts = dictService.findAll()
                    .stream().collect(Collectors.toMap(DictDO::getId, Function.identity()));
        }

        @Override
        public void destroy() {
            // 销毁方法
            allDicts.clear();
        }

        @Override
        public Map<String, ?> get(Collection<String> keys) {
            return allDicts;
        }
    }
}
