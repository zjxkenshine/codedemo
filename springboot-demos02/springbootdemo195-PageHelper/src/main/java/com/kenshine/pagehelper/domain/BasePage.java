package com.kenshine.pagehelper.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * @author ：kenshine
 * @date ：Created in 2021/12/22 9:22
 * @description：分页参数
 * @modified By：
 * @version: $
 */
@Data
@Accessors(chain = true)
public class BasePage implements Serializable {
    private static final long serialVersionUID = 1L;

    /**请求参数 */
    @TableField(exist = false)
    private Map<String, Object> params = new HashMap<>();

}
