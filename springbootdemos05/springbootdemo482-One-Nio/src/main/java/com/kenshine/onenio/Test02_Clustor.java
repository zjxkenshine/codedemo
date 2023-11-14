package com.kenshine.onenio;

import lombok.SneakyThrows;
import one.nio.cluster.ServiceProvider;
import one.nio.cluster.ServiceUnavailableException;
import one.nio.cluster.WeightCluster;
import one.nio.http.HttpClient;
import one.nio.http.HttpProvider;
import one.nio.http.Request;
import one.nio.http.Response;
import one.nio.net.ConnectionString;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.sound.midi.Soundbank;
import java.io.IOException;
import java.net.SocketTimeoutException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author by kenshine
 * @Classname Test02_Clustor
 * @Description 集群工具
 * @Date 2023-11-14 8:18
 * @modified By：
 * @version: 1.0$
 */
public class Test02_Clustor {

    /**
     * HttpServiceProvider
     */
    public class CustomServiceProvider implements ServiceProvider{
        private final CloseableHttpClient client;
        private final AtomicBoolean available;
        private final AtomicInteger failures;
        private String config;

        public CustomServiceProvider(CloseableHttpClient client) {
            this.client = client;
            this.available = new AtomicBoolean(true);
            this.failures = new AtomicInteger();
            this.config = "none";
        }

        public CustomServiceProvider(CloseableHttpClient client,String config) {
            this.client = client;
            this.available = new AtomicBoolean(true);
            this.failures = new AtomicInteger();
            this.config = config;
        }

        @Override
        public boolean available() {
            return available.get();
        }

        @Override
        public boolean check() throws Exception {
            HttpGet httpGet = new HttpGet("/");
            CloseableHttpResponse response = client.execute(httpGet);
            if (response.getStatusLine().getStatusCode() >= 500) {
                throw new IOException(this + " check failed with status " + response.getAllHeaders()[0]);
            }
            return true;
        }

        @Override
        public boolean enable() {
            if (available.compareAndSet(false, true)) {
                failures.set(0);
                return true;
            }
            return false;
        }

        @Override
        public boolean disable() {
            return available.compareAndSet(true, false);
        }

        @SneakyThrows
        @Override
        public void close() {
            available.set(false);
            client.close();
        }

        @Override
        public String toString() {
            return "HttpProvider[" + client.toString()+ "]";
        }

        /**
         * 调用
         */
        public CloseableHttpResponse invoke(HttpUriRequest request) throws Exception {
            System.out.println("client"+config+"is invoked");
            CloseableHttpResponse response = client.execute(request);
            if (response.getStatusLine().getStatusCode() >= 500) {
                throw new IOException(this + " call failed with status " + response.getAllHeaders()[0]);
            }
            return response;
        }

        public AtomicInteger getFailures() {
            return failures;
        }
    }


    /**
     * HttpClient集群
     */
    public class CustomCluster extends WeightCluster<CustomServiceProvider> {
        private Logger logger = LoggerFactory.getLogger(CustomCluster.class);
        // 重试次数
        protected volatile int retries = 3;
        // 最大失败次数
        protected volatile int maxFailures = 5;

        // 新配置，替换原有的provider
        public void configure(String configuration) {
            Map<CustomServiceProvider, Integer> newProviders = createProviders(configuration);
            List<CustomServiceProvider> oldProviders = replaceProviders(newProviders);
            for (CustomServiceProvider provider : oldProviders) {
                provider.close();
            }
        }

        // 创建ServiceProvider
        protected Map<CustomServiceProvider, Integer> createProviders(String configuration) {
            HashMap<CustomServiceProvider, Integer> providers = new HashMap<>();
            // StringTokenizer 使用,拆分配置 默认使用" \t\n\r\f"作为分隔符
            for (StringTokenizer st = new StringTokenizer(configuration,","); st.hasMoreTokens(); ) {
                String token =st.nextToken();
                CustomServiceProvider provider = createProvider(token);
                int weight = Integer.parseInt(token);
                providers.put(provider, weight);
            }
            return providers;
        }

        // 创建serviceProvider 使用config配置 这里使用默认配置
        protected CustomServiceProvider createProvider(String config) {
            return new CustomServiceProvider(HttpClients.createDefault(),config);
        }

        // 调用
        public CloseableHttpResponse invoke(HttpUriRequest request) throws ServiceUnavailableException {
            final int retries = this.retries;
            // 最大重试3次
            for (int i = 0; i < retries; i++) {
                CustomServiceProvider provider = getProvider();
                try {
                    CloseableHttpResponse response = provider.invoke(request);
                    provider.getFailures().set(0);
                    return response;
                } catch (Exception e) {
                    // 最大失败3次，关闭provider
                    if (provider.getFailures().incrementAndGet() >= maxFailures) {
                        disableProvider(provider);
                    }
                    logger.warn("{} invocation failed {}", provider, request.getURI(), e);
                }
            }
            throw new ServiceUnavailableException("Cluster invocation failed");
        }
    }

    /**
     * 测试自定义Http集群
     */
    @Test
    public void testCustomCluster() throws ServiceUnavailableException, IOException {
        CustomCluster customCluster=new CustomCluster();
        // 三个节点 对应权重
        customCluster.configure("1,3,2");
        HttpGet httpGet = new HttpGet("https://www.baidu.com/");
        CloseableHttpResponse closeableHttpResponse=customCluster.invoke(httpGet);
        System.out.println(closeableHttpResponse.getEntity().getContent().toString());
    }
}
