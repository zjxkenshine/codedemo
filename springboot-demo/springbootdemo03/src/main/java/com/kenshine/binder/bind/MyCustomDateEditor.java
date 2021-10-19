package com.kenshine.binder.bind;

import java.beans.PropertyEditorSupport;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * @author ：kenshine
 * @date ：Created in 2021/10/19 14:31
 * @description：扩展类型转换
 * @modified By：
 * @version: $
 */
public class MyCustomDateEditor extends PropertyEditorSupport{

    /**
     * @see java.beans.PropertyEditorSupport#setAsText(java.lang.String)
     * 前端传入的是unix时间戳,也就是long型,然后后台接收到前端传入的这个参数时会先被转换为String类型,
     * 默认情况下,是不能将String转为Date类型的,所以我们再这里将String字符串变为Date类型!
     */
    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        setValue(new Date(Long.decode(text)));
    }

    /**
     * @see java.beans.PropertyEditorSupport#getAsText()
     * 后台给前端返回响应信息,也要处理Date类型,将Date类型转为String.
     */
    @Override
    public String getAsText() {
        Date value = (Date) getValue();
        return (value != null ? String.valueOf(TimeUnit.MILLISECONDS.toSeconds(value.getTime())) : "");
    }

}
