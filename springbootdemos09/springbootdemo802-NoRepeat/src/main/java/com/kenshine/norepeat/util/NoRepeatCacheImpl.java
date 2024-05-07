package com.kenshine.norepeat.util;

import idea.verlif.spring.norepeat.cache.NoRepeatCache;
import idea.verlif.spring.norepeat.entity.RequestFlag;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author kenshine
 * 自定义请求旧值处理
 */
@Component
public class NoRepeatCacheImpl implements NoRepeatCache {

    private final Map<String, RequestFlag> flagMap;

    public NoRepeatCacheImpl() {
        flagMap = new ConcurrentHashMap<>();
    }

    @Override
    public void add(String key, RequestFlag flag) {
        flagMap.put(key, flag);
    }

    @Override
    public synchronized RequestFlag get(String key) {
        RequestFlag flag = flagMap.get(key);
        if (flag != null && (flag.getTime() + flag.getInterval()) < System.currentTimeMillis()) {
            flagMap.remove(key);
            return null;
        }
        return flag;
    }

   /**
    * 通过请求来生成对应缓存的key
    *
    * @param request 请求
    * @return 缓存key
    */
   @Override
   public String genKey(HttpServletRequest request) {
      return request.getRequestURI() + request.getHeader("user");
   }
}