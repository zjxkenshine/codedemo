package com.kenshine.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.util.List;

/**
 * @author ：kenshine
 * @date ：Created in 2021/10/25 9:02
 * @description：Es用户 使用ElasticsearchRestTemplate测试
 * @modified By：
 * @version: $
 *
 */
@Data
@NoArgsConstructor
@Accessors(chain = true)
@Document(indexName = "doc_bean",shards = 1, replicas = 0)
public class DocBean {

    @Id
    private Long id;

    @Field(type = FieldType.Keyword)
    private String firstCode;

    @Field(type = FieldType.Keyword)
    private String secordCode;

    @Field(type = FieldType.Text, analyzer = "ik_max_word")
    private String content;

    @Field(type = FieldType.Integer)
    private Integer type;

    public DocBean(Long id,String firstCode,String secordCode,String content,Integer type){
        this.id=id;
        this.firstCode=firstCode;
        this.secordCode=secordCode;
        this.content=content;
        this.type=type;
    }

}
