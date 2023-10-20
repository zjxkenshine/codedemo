package com.kenshine.milo.client;

import org.eclipse.milo.opcua.sdk.client.OpcUaClient;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author by kenshine
 * @Classname OpcuaStartMilo
 * @Description 使用milo官方测试地址
 * @Date 2023-10-20 10:07
 * @modified By：
 * @version: 1.0$
 */
public class OpcuaStartMilo {

    @Test
    public void start() throws Exception {
        OpcuaClient opcUaClientService = new OpcuaClient();

        // 与OPC UA服务端建立连接，并返回客户端实例
        OpcUaClient client = opcUaClientService.connectOpcUaServer("milo.digitalpetri.com", "62541", "/milo");

        // 遍历所有节点
//        opcUaClientService.listNode(client, null);

        // 读取指定节点的值
        opcUaClientService.readNodeValue(client, 2, "Dynamic/RandomInt32");
        opcUaClientService.readNodeValue(client, 2, "Dynamic/RandomInt64");

        // 向指定节点写入数据
//        opcUaClientService.writeNodeValue(client, 2, "Demo.1500PLC.D1", 6f);

        // 订阅指定节点
//        opcUaClientService.subscribe(client, 2, "Dynamic/RandomDouble");

        // 批量订阅多个节点
        List<String> identifiers = new ArrayList<>();
        identifiers.add("Dynamic/RandomDouble");
        identifiers.add("Dynamic/RandomFloat");

        opcUaClientService.setBatchNamespaceIndex(2);
        opcUaClientService.setBatchIdentifiers(identifiers);

//        opcUaClientService.subscribeBatch(client);
        opcUaClientService.subscribeBatchWithReconnect(client);
    }
}
