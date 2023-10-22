package com.kenshine.ice.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


/**
 * 发放余额
 */
@Service
@Slf4j
public class SendService {

    public boolean sendAmount(Integer uid, double value) {
        log.info("=======send amount uid:{}, value:{}", uid, value);
        return true;
    }

    public boolean sendPoint(Integer uid, double value) {
        log.info("=======send point uid:{}, value:{}", uid, value);
        return true;
    }
}
