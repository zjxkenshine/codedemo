package com.kenshine.slor.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.solr.client.solrj.beans.Field;
import org.springframework.data.solr.core.mapping.SolrDocument;

import java.io.Serializable;

/**
 * @author ：kenshine
 * @date ：Created in 2021/11/23 9:23
 * @description：用户
 * @modified By：
 * @version: $
 */
@SolrDocument(collection="demo106")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User implements Serializable {

    //必须实现可序列化接口，要在网络上传输
    //使用这个注释，里面的名字是根据你在solr数据库中配置的来决定
    @Field("id")
    private String id;
    @Field("username")
    private String name;
    @Field("sex")
    private String sex;
    @Field("address")
    private String address;
    @Field("host")
    private Integer host;

}
