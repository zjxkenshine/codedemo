package com.kenshine.ice.result;

import com.ice.core.annotation.IceField;
import com.ice.core.annotation.IceNode;
import com.ice.core.context.IceRoam;
import com.ice.core.leaf.roam.BaseLeafRoamResult;
import com.kenshine.ice.service.SendService;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.beans.factory.annotation.Autowired;

@Data
@EqualsAndHashCode(callSuper = true)
@IceNode(name = "发放积分节点", desc = "用于发放积分奖励")
public class PointResult extends BaseLeafRoamResult {

    @Autowired
    private SendService sendService2;
    @IceField(name = "发给谁", desc = "发放的key 如uid")
    private String key;
    @IceField(name = "发多少", desc = "发多少余额 如10")
    private double value;

    @Override
    protected boolean doRoamResult(IceRoam roam) {
        Integer uid = roam.getMulti(key);
        if (uid == null || value <= 0) {
            return false;
        }
        boolean res = sendService2.sendPoint(uid, value);
        roam.put("SEND_POINT", res);
        return res;
    }
}
