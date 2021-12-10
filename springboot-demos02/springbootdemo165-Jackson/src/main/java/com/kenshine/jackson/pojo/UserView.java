package com.kenshine.jackson.pojo;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.kenshine.jackson.serializer.CustomDateSerialize;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author ：kenshine
 * @date ：Created in 2021/12/10 8:55
 * @description：json分组测试
 * @modified By：
 * @version: $
 */
@Data
//sex字段会被忽略
@JsonIgnoreProperties({"sex"})
public class UserView {
    /**分组接口*/
    public interface IdView{}
    public interface IdNameView extends IdView{}

    @JsonView(IdView.class)
    private Integer id;

    @JsonView(IdNameView.class)
    private String name;

    @JsonIgnore
    @JsonView(IdView.class)
    private Integer age;

    @JsonView(IdView.class)
    private String sex;

    /**
     * @JsonProperty指定别名
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH-mm-ss")
    @JsonView(IdView.class)
    @JsonProperty("createTime")
    private LocalDateTime date;


    /**
     *  使用自定义序列化器
     */
    @JsonSerialize(using = CustomDateSerialize.class)
    @JsonView(IdView.class)
    @JsonProperty("updateTime")
    private LocalDateTime date2;

}
