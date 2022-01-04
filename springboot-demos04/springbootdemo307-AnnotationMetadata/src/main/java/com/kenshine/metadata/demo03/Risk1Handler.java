package com.kenshine.metadata.demo03;

import org.springframework.stereotype.Component;

/**
 * @author ：kenshine
 * @date ：Created in 2022/1/4 11:11
 * @description：
 * @modified By：
 * @version: $
 */
@Component
@HandleType("risk1")
public class Risk1Handler extends AbstractRiskHandler {

    @Override
    protected void buildSceneData(String req) {
        System.out.println("场景1");
    }

}
