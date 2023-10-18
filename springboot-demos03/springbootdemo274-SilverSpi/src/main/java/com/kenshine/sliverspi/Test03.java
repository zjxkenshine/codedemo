package com.kenshine.sliverspi;

import com.kenshine.sliverspi.test03.IUser;
import com.kenshine.sliverspi.test03.MarketEnum;
import com.kenshine.sliverspi.test03.UserDO;
import com.yihui.silver.spi.SpiLoader;
import com.yihui.silver.spi.exception.SpiProxyCompileException;
import org.junit.Test;

/**
 * @author by kenshine
 * @Classname Test03
 * @Description 自定义Selector选择器
 * @Date 2023-10-18 13:53
 * @modified By：
 * @version: 1.0$
 */
public class Test03 {

    @Test
    public void test() throws SpiProxyCompileException {
        SpiLoader<IUser> loader = SpiLoader.load(IUser.class);
        IUser user = loader.getAdaptive();

        UserDO weixinUser = new UserDO();
        weixinUser.setAvatar("weixin.avatar.jpg");
        weixinUser.setUname("微信用户");
        weixinUser.setMarket(MarketEnum.WEIXIN);
        user.welcome(weixinUser);

        UserDO qqUser = new UserDO();
        qqUser.setAvatar("qq.avatar.jpg");
        qqUser.setUname("qq用户");
        qqUser.setMarket(MarketEnum.QQ);
        user.welcome(qqUser);
    }
}
