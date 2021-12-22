package com.kenshine.pagehelper.service.base;

import com.baomidou.mybatisplus.extension.service.IService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.kenshine.pagehelper.utils.ServletUtils;

import java.util.List;
import java.util.function.Supplier;

/**
 * @author ：kenshine
 * @date ：Created in 2021/12/22 9:30
 * @description：分页
 * @modified By：
 * @version: $
 */
public class PageService{
    private PageService(){}

    /**
     * 当前记录起始索引
     */
    public static final String PAGE_NUM = "pageNum";

    /**
     * 每页显示记录数
     */
    public static final String PAGE_SIZE = "pageSize";

    /**
     * 当前记录起始索引 默认值
     */
    public static final int DEFAULT_PAGE_NUM = 1;

    /**
     * 每页显示记录数 默认值 默认查全部
     */
    public static final int DEFAULT_PAGE_SIZE = Integer.MAX_VALUE;

    public static <T> PageInfo<T> selectPage(Supplier<List<T>> listSupplier) {
        //获取PageNum参数
        Integer pageNum = ServletUtils.getParameterToInt(PAGE_NUM, DEFAULT_PAGE_NUM);
        //获取PageSize参数
        Integer pageSize = ServletUtils.getParameterToInt(PAGE_SIZE, DEFAULT_PAGE_SIZE);
        PageHelper.startPage(pageNum,pageSize);
        return new PageInfo<>(listSupplier.get());
    }

}
