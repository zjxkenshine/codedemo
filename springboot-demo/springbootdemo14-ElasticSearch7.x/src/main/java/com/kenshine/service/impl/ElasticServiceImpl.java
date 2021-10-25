package com.kenshine.service.impl;

import com.kenshine.domain.DocBean;
import com.kenshine.repository.ElasticRepository;
import com.kenshine.service.IElasticService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.data.elasticsearch.core.IndexOperations;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.List;

/**
 * @author ：kenshine
 * @date ：Created in 2021/10/25 9:24
 * @description：业务实现
 * @modified By：
 * @version: $
 */
@Service
public class ElasticServiceImpl implements IElasticService {
    /**
     * 使用 ElasticsearchRestTemplate
     */
    @Autowired
    private ElasticsearchRestTemplate elasticsearchTemplate;

    @Autowired
    private ElasticRepository elasticRepository;

    private Pageable pageable = PageRequest.of(0,10);

    @Override
    public void createIndex() {
        /**
         * 会和@Document(indexName = "doc_bean",shards = 1, replicas = 0)冲突
         */
        //elasticsearchTemplate.createIndex(DocBean.class);
        IndexOperations ops =elasticsearchTemplate.indexOps(DocBean.class);
        if (ops.exists()) ops.delete();
        ops.create();
        ops.refresh();
//      ops.putMapping(ops.createMapping());
    }

    @Override
    public void deleteIndex(String index) {
        //过时方法
        //elasticsearchTemplate.deleteIndex(index);
        //https://blog.csdn.net/weixin_43057381/article/details/119320411 新方法
        elasticsearchTemplate.indexOps(DocBean.class).delete();
    }

    @Override
    public void save(DocBean docBean) {
        elasticRepository.save(docBean);
    }

    @Override
    public void saveAll(List<DocBean> list) {
        elasticRepository.saveAll(list);
    }

    @Override
    public Iterator<DocBean> findAll() {
        return elasticRepository.findAll().iterator();
    }

    @Override
    public Page<DocBean> findByContent(String content) {
        return elasticRepository.findByContent(content,pageable);
    }

    @Override
    public Page<DocBean> findByFirstCode(String firstCode) {
        return elasticRepository.findByFirstCode(firstCode,pageable);
    }

    @Override
    public Page<DocBean> findBySecordCode(String secordCode) {
        return elasticRepository.findBySecordCode(secordCode,pageable);
    }

    @Override
    public Page<DocBean> query(String key) {
        return elasticRepository.findByContent(key,pageable);
    }


}
