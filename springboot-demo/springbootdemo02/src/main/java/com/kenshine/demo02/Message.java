package com.kenshine.demo02;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author ：kenshine
 * @date ：Created in 2021/10/18 9:41
 * @description：文件上传测试消息
 * @modified By：
 * @version: 1.0$
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Message{


    /**
     *0表示成功,-1表示失败
     */
    int status;

    /**
     * 向前端返回的内容
     */
    String massage;

}
