package com.kenshine.ice.flow;

import com.googlecode.aviator.AviatorEvaluator;
import com.googlecode.aviator.Expression;
import com.ice.common.enums.NodeRunStateEnum;
import com.ice.core.annotation.IceIgnore;
import com.ice.core.context.IceContext;
import com.ice.core.context.IceRoam;
import com.ice.core.leaf.roam.BaseLeafRoamFlow;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.extern.slf4j.Slf4j;

/**
 * 使用Aviator 表达式
 */
@Data
@Slf4j
@EqualsAndHashCode(callSuper = true)
public class AviatorFlow extends BaseLeafRoamFlow {

    private String exp;

    @IceIgnore
    private Expression compiledExpression;

    @Override
    protected boolean doRoamFlow(IceRoam roam) {
        return (boolean) compiledExpression.execute(roam);
    }

    @Override
    public void afterPropertiesSet() {
        if (exp != null) {
            this.compiledExpression = AviatorEvaluator.compile(exp, true);
        }
    }

    @Override
    public NodeRunStateEnum errorHandle(IceContext ctx, Throwable t) {
        log.error("error occur id:{} e:", this.findIceNodeId(), t);
        return super.errorHandle(ctx, t);
    }
}
