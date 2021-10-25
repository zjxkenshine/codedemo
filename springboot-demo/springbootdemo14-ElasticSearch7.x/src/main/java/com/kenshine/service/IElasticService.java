package com.kenshine.service;

import com.kenshine.domain.DocBean;
import org.springframework.data.domain.Page;

import java.util.Iterator;
import java.util.List;

/**
 * @author ：kenshine
 * @date ：Created in 2021/10/25 9:24
 * @description：业务逻辑层
 * @modified By：
 * @version: $
 */
public interface IElasticService {
    void createIndex();

    void deleteIndex(String index);

    void save(DocBean docBean);

    void saveAll(List<DocBean> list);

    Iterator<DocBean> findAll();

    Page<DocBean> findByContent(String content);

    Page<DocBean> findByFirstCode(String firstCode);

    Page<DocBean> findBySecordCode(String secordCode);

    Page<DocBean> query(String key);

}
