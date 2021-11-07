package com.kenshine.flowable.entity;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 分页实体类，通过配置文件对 page， limit 进行默认值注入
 */
@Data
@Component
public class PageEntity<T> {

    // 数据
    private T data;

    // 页码
    private Integer page;

    // 每页条数
    private Integer limit;

    // 数据总条数
    private Long total;

    // 总页数
    private Integer totalPage;

    public PageEntity() {}

    public PageEntity(Integer page, Integer limit, Long total) {
        this.page = page;
        this.limit = limit;
        this.total = total;
    }

    public PageEntity(Integer page, Integer limit, Integer total) {
        this.page = page;
        this.limit = limit;
        this.total = total.longValue();
    }

    /**
     * 计算分页起始索引
     * @param page
     * @param limit
     * @return
     */
    public static Integer startIndex(Integer page, Integer limit) {
        return (page - 1) * limit;
    }

    /**
     * 计算分页结束索引
     * @param page
     * @param limit
     * @param total
     * @return
     */
    public static Integer endIndex(Integer page, Integer limit, Integer total) {
        Integer endDataIndexAddOne;
        if ((page - 1) * limit + limit > total) {
            endDataIndexAddOne = total;
        } else {
            endDataIndexAddOne = (page - 1) * limit + limit;
        }
        return endDataIndexAddOne;
    }

    /**
     * 计算总页数
     */
    public Integer calculateTotalPage() {
        if (this.limit != null && this.total != null) {
            this.totalPage = (this.total.intValue() - 1) / this.limit + 1;
        }
        return this.totalPage;
    }

    /**
     * 人工分页
     * @param page 第几页
     * @param limit 每页几条
     * @param dataList 数据总列表
     * @return
     */
    public List<T> pageData(Integer page, Integer limit, Integer total, List<T> dataList) {
        // 起始数据索引
        Integer startDataIndex = startIndex(page, limit);
        // 结束索引，最后一位不会被算进去
        Integer endDataIndexAddOne = endIndex(page, limit, total);
        return dataList.subList(startDataIndex, endDataIndexAddOne);
    }

}
