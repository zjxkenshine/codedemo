package com.kenshine.akali.service;

import com.kenshine.akali.model.User;
import org.dromara.akali.annotation.AkaliFallback;
import org.dromara.akali.annotation.AkaliHot;
import org.dromara.akali.enums.FlowGradeEnum;
import org.springframework.stereotype.Service;

/**
 * @author by kenshine
 * @Classname TestService
 * @Description 测试Service
 * @Date 2023-11-30 9:10
 * @modified By：
 * @version: 1.0$
 */
@Service
public class TestService {

    /**
     * 热点处理 QPS
     * 当相同的skuCode在5秒内超过50次调用时，会自动把这个skuCode的值提为热点，并用最后一次的返回值直接返回
     */
    @AkaliHot(grade = FlowGradeEnum.FLOW_GRADE_QPS, count = 50, duration = 5)
    public User getUser(Integer id){
        return new User(id,"kenshine"+id);
    }

    /**
     * 热点处理 线程
     * 如果某个skuCode在5秒之内有超过50个线程正在运行，那么就提为热点，并用热点数据直接返回
     */
    @AkaliHot(grade = FlowGradeEnum.FLOW_GRADE_THREAD, count = 5, duration = 5)
    public User getUser1(Integer id){
        return new User(id,"pig"+id);
    }


    /**
     * 降级 当这个方法的同时运行的线程超过100个时，触发降级
     * 降级会自动调用原方法名+Fallback方法名(并且参数要一致)
     * 也有QPS降级
     */
    @AkaliFallback(grade = FlowGradeEnum.FLOW_GRADE_THREAD, count = 100)
    public String sayHi(String name){
        return "hi,"+name;
    }

    public String sayHiFallback(String name){
        return "fallback str";
    }

    @AkaliFallback(grade = FlowGradeEnum.FLOW_GRADE_QPS, count = 2)
    public String sayHi2(String name){
        return "hi,"+name;
    }

    public String sayHi2Fallback(String name){
        return "fallback str";
    }
}
