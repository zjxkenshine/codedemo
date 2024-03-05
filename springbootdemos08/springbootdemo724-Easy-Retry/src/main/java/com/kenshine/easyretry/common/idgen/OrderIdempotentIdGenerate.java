package com.kenshine.easyretry.common.idgen;

import cn.hutool.crypto.SecureUtil;
import com.aizuda.easy.retry.client.core.IdempotentIdGenerate;
import com.aizuda.easy.retry.common.core.model.IdempotentIdContext;
import com.kenshine.easyretry.model.OrderVo;

/**
 * @author kenshine
 * 订单幂等id生成
 */
public class OrderIdempotentIdGenerate implements IdempotentIdGenerate {

    @Override
    public String idGenerate(IdempotentIdContext idempotentIdContext) throws Exception {
        Object[] args = idempotentIdContext.getArgs();
        OrderVo orderVo = (OrderVo) args[0];
        return SecureUtil.md5(orderVo.getOrderId());
    }

}