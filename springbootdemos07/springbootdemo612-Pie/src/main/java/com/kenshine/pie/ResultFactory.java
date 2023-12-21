package com.kenshine.pie;

import com.feiniaojin.ddd.ecosystem.pie.OutboundFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 结果工厂
 * @author kenshine
 */
public class ResultFactory implements OutboundFactory {

    private Logger logger = LoggerFactory.getLogger(ResultFactory.class);

    @Override
    public Object newInstance() {
        Result result = new Result();
        result.setCode(0);
        result.setMsg("ok");
        return result;
    }
}