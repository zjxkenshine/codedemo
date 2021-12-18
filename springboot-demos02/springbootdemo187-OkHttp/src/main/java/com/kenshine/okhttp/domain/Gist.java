package com.kenshine.okhttp.domain;

import lombok.Data;

import java.io.Serializable;
import java.util.Map;

/**
 * @author ：kenshine
 * @date ：Created in 2021/12/18 14:40
 * @description：
 * @modified By：
 * @version: $
 */
@Data
public class Gist implements Serializable {
    Map<String, GistFile> files;
}
