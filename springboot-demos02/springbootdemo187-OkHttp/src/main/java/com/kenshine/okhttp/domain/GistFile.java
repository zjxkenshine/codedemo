package com.kenshine.okhttp.domain;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @author ：kenshine
 * @date ：Created in 2021/12/18 14:41
 * @description：
 * @modified By：
 * @version: $
 */
@Data
@Accessors(chain = true)
public class GistFile implements Serializable {
    String content;
}
