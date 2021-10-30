package com.kenshine.i18n.web;

import com.kenshine.i18n.apireturn.ResultData;
import com.kenshine.i18n.enums.CodeEnum;
import com.kenshine.i18n.util.LocaleMessageSourceUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author ：kenshine
 * @date ：Created in 2021/10/30 15:07
 * @description：测试配置
 * @modified By：
 * @version: $
 */
@RestController
public class TestController {
    @Resource
    private LocaleMessageSourceUtil localeMessageSourceUtil;

    @GetMapping("test")
    public ResultData test(@RequestParam int testNum) {
        System.out.println(localeMessageSourceUtil.getMessage(""));

        if (1==testNum){
            return ResultData.success(CodeEnum.SUCCESS);
        }
        if (2==testNum){
            return ResultData.success(CodeEnum.FAIL);
        }
        if (3==testNum){
            return ResultData.success("自定义的返回语");
        }
        return ResultData.success(CodeEnum.SUCCESS);
    }

}
