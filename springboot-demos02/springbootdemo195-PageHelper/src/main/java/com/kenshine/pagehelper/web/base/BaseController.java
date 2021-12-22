package com.kenshine.pagehelper.web.base;

import com.github.pagehelper.PageInfo;
import com.kenshine.pagehelper.service.base.PageService;

import java.util.List;
import java.util.function.Supplier;

/**
 * @author ：kenshine
 * @date ：Created in 2021/12/22 10:30
 * @description：
 * @modified By：
 * @version: $
 */
public class BaseController {

    public <T> PageInfo<T> page(Supplier<List<T>> listSupplier){
        return PageService.selectPage(listSupplier);
    }

}
