package com.kenshine.msgsimple;

import com.github.fge.msgsimple.bundle.MessageBundle;
import com.github.fge.msgsimple.bundle.PropertiesBundle;
import com.github.fge.msgsimple.load.MessageBundleLoader;
import com.github.fge.msgsimple.load.MessageBundles;

/**
 * @author kenshine
 * 运行时加载 ResourceBundle
 */
public final class MyMessageBundle implements MessageBundleLoader {
    @Override
    public MessageBundle getBundle(){
        return PropertiesBundle.forPath("msg/test.properties");
    }

    public static void main(String[] args) {
        // 运行时加载MessageBundle
        MessageBundle mainBundle = MessageBundles.getBundle(MyMessageBundle.class);
    }
}

