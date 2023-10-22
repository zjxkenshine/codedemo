package com.kenshine.ice.none;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ice.core.context.IcePack;
import com.ice.core.leaf.pack.BaseLeafPackNone;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.beans.factory.annotation.Value;

import java.util.Date;


/**
 * 修改时间节点
 */
@Data
@EqualsAndHashCode(callSuper = true)
public final class TimeChangeNone extends BaseLeafPackNone {

    /**
     * 对应后台配置中节点json
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date time;

    private long cursorMills;

    // 环境，仅在测试环境生效
    @Value("${environment}")
    private String environment="dev";

    /*
     * 叶子节点处理
     * @param pack 包裹
     */
    @Override
    protected void doPackNone(IcePack pack) {
        if (!"prod".equals(environment)) {
            if (time != null) {
                pack.setRequestTime(time.getTime());
            } else {
                pack.setRequestTime(pack.getRequestTime() + cursorMills);
            }
        }
    }
}
