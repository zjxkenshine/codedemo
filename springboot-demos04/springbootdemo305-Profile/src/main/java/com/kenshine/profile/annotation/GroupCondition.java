package com.kenshine.profile.annotation;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;
import org.springframework.util.MultiValueMap;


/**
 * @author ：kenshine
 * @date ：Created in 2022/1/3 19:51
 * @description：
 * @modified By：
 * @version: $
 */
public class GroupCondition implements Condition {

    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        String group = context.getEnvironment().getProperty("spring.group");
        MultiValueMap<String, Object> attrs = metadata.getAllAnnotationAttributes(Group.class.getName());
        if (attrs != null) {
            for (Object value : attrs.get("value")) {
                //分组与配置的相同
                if(group.equals(value)){
                    return true;
                }
            }
        }
        return false;
    }
}
