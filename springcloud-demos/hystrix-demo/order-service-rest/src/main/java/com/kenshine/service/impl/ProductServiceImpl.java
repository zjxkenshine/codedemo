package com.kenshine.service.impl;

import com.kenshine.pojo.Product;
import com.kenshine.service.ProductService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCollapser;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.netflix.hystrix.contrib.javanica.conf.HystrixPropertiesManager;
import com.netflix.ribbon.proxy.annotation.Hystrix;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Future;

/**
 * productService 实现类
 * 使用Ribbon需要写
 * @author Kenshine
 */
@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private RestTemplate restTemplate;

    /**
     * @Cacheable开启Redis缓存
     * @HystrixCommand 声明服务容错
     * @return
     */
    //线程池隔离
    @HystrixCommand(
            groupKey = "order-productService-listPool",     //服务名称，相同名称使用同一个线程池
            commandKey = "selectProductList",               //接口名称，默认为方法名
            threadPoolKey = "order-productService-listPool",        //线程池名称，相同名称使用同一个线程池
            commandProperties = {
                    //超时时间，默认1000ms
                    @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value="5000")
            },
            threadPoolProperties = {
                    //线程池大小(加起来等于Tomcat线程池)
                    @HystrixProperty(name="coreSize",value="6"),
                    //队列等待阈值（最大队列长度，默认-1）
                    @HystrixProperty(name="maxQueueSize",value="100"),
                    //线程存活时间，默认1min
                    @HystrixProperty(name="keepAliveTimeMinutes",value="2"),
                    //超出队列等待阈值执行拒绝策略
                    @HystrixProperty(name="queueSizeRejectionThreshold",value="100")
            },fallbackMethod = "selectProductListFallback"
    )
    //信号量隔离
//    @HystrixCommand(commandProperties = {
//            //超时时间，默认1000ms
//            @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value="5000"),
//            //信号量隔离,默认线程池隔离
//            @HystrixProperty(name= HystrixPropertiesManager.EXECUTION_ISOLATION_STRATEGY,value="SEMAPHORE")
//            //信号量最大并发，调小一些方便模拟高并发
//            @HystrixProperty(name = HystrixPropertiesManager.EXECUTION_ISOLATION_SEMAPHORE_MAX_CONCURRENT_REQUESTS,value = "6")
//    },fallbackMethod = "selectProductListFallback")
    @Cacheable(cacheNames = "orderService:product:list")
    @Override
    public List<Product> selectProductList() {
        System.out.println("-----------orderService------------selectProductList---------------");
        //ResponseEntity：封装了返回数据
        ResponseEntity<List<Product>> response=restTemplate.exchange(
                "http://service-provider/product/list",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Product>>() {
                }
        );
        return response.getBody();
    }

    /**
     * @param ids
     * @return
     * HystrixCommand 注解配置合并的请求
     */
    @HystrixCommand
    @Override
    public List<Product> selectProductByIds(List<Integer> ids) {
        System.out.println("-----------orderService------------selectProductByIds---------------");
        StringBuffer sb=new StringBuffer();
        ids.forEach(id->sb.append("id="+id+"&"));
        return restTemplate.getForObject("http://service-provider/product/listByIds?"+sb.toString(), List.class);
    }

    /**
     * Cacheable 缓存注解
     * @param id
     * @return
     */
    @HystrixCommand(
            groupKey = "order-productService-singlePool",     //服务名称，相同名称使用同一个线程池
            commandKey = "selectProductById",               //接口名称，默认为方法名
            threadPoolKey = "order-productService-singlePool",        //线程池名称，相同名称使用同一个线程池
            commandProperties = {
                    //超时时间，默认1000ms
                    @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value="5000")
            },
            threadPoolProperties = {
                    //线程池大小(加起来等于Tomcat线程池)
                    @HystrixProperty(name="coreSize",value="3"),
                    //队列等待阈值（最大队列长度，默认-1）
                    @HystrixProperty(name="maxQueueSize",value="100"),
                    //线程存活时间，默认1min
                    @HystrixProperty(name="keepAliveTimeMinutes",value="2"),
                    //超出队列等待阈值执行拒绝策略
                    @HystrixProperty(name="queueSizeRejectionThreshold",value="100")
            },fallbackMethod = "selectProductByIdFallback"
    )
    @Cacheable(cacheNames = "orderService:product:single",key = "#id")
    @Override
    public Product selectProductById(Integer id) {
        System.out.println("-----------orderService------------selectProductById---------------");
        return restTemplate.getForObject("http://service-provider/product/"+id,Product.class);
    }

    /**
     * 异步请求,请求合并
     * 处理请求合并的方法一定要异步
     * @param id
     * @return
     */
    @HystrixCollapser(batchMethod = "selectProductByIds",       //合并请求的方法
            scope = com.netflix.hystrix.HystrixCollapser.Scope.GLOBAL,         //请求方式
            collapserProperties = {
                    //间隔多久的请求会被合并，默认10ms
                    @HystrixProperty(name = "timerDelayInMilliseconds", value = "20"),
                    //批处理之前，批处理中允许的最大请求数
                    @HystrixProperty(name="maxRequestsInBatch",value = "200")
            })
    @Override
    public Future<Product> selectProductById2(Integer id) {
        System.out.println("-----------orderService------------selectProductById2---------------");
        return null;
    }

    /**
     * 服务熔断示例
     * @param id
     * @return
     * 熔断声明
     * fallbackMethod 单独使用就是服务降级
     */
    @HystrixCommand(
            commandProperties = {
                    //10秒内请求数大于10个就启动熔断器，当请求符合熔断条件触发fallbackMethod，默认20
                    @HystrixProperty(name = HystrixPropertiesManager.CIRCUIT_BREAKER_REQUEST_VOLUME_THRESHOLD,value = "10"),
                    //请求错误率大于 50% 就启动熔断器，然后for循环发起重试请求，当请求符合熔断条件触发 fallbackMethod
                    @HystrixProperty(name = HystrixPropertiesManager.CIRCUIT_BREAKER_ERROR_THRESHOLD_PERCENTAGE,value = "50"),
                    //熔断多少秒后去重试请求，默认5s
                    @HystrixProperty(name = HystrixPropertiesManager.CIRCUIT_BREAKER_SLEEP_WINDOW_IN_MILLISECONDS,value = "5000"),
            },fallbackMethod = "selectProductByIdFallback"
    )
     // 服务降级
    //  @HystrixCommand(fallbackMethod = "selectProductByIdFallback")
    @Override
    public Product selectProductById3(Integer id) {
        System.out.println("----selectProductById------"+ LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_TIME));
        //模拟查询主键为1的商品导致异常
        if(id==1){
            throw new RuntimeException("查询主键为 1 的商品导致异常");
        }
        return restTemplate.getForObject("http://service-provider/product/"+id,Product.class);
    }

    /**
     * 托底方法，服务降级之后的方法
     * @return
     */
    private List<Product> selectProductListFallback(){
        System.out.println("---------------selectProductFallback------------------------------------");
        return Arrays.asList(
                new Product(1,"托底数据-手机",1,5800D),
                new Product(2,"托底数据-笔记本电脑",1,6666D),
                new Product(3,"托底数据-小米平板",5,2020D)
        );
    }

    /**
     * 托底方法
     * @return
     */
    private Product selectProductByIdFallback(Integer id){
        return new Product(id,"托底数据",1,2666D);
    }

}
