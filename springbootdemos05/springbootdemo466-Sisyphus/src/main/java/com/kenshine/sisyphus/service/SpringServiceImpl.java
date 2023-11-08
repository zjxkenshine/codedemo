package com.kenshine.sisyphus.service;

import com.github.houbb.sisyphus.annotation.annotation.Retry;
import org.springframework.stereotype.Service;

@Service
public class SpringServiceImpl implements SpringService {

    @Override
    @Retry
    public String query() {
        System.out.println("spring service query...");
        throw new RuntimeException();
    }

}