package com.kenshine.resubmit.service;

import com.github.houbb.resubmit.api.annotation.Resubmit;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    /**
     * 5秒钟只能重复执行一次
     */
    @Resubmit(5000)
    public void queryInfo(final String id) {
        System.out.println("query info: " + id);
    }

}