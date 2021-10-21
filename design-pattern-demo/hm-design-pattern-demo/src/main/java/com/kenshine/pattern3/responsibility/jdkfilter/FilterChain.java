package com.kenshine.pattern3.responsibility.jdkfilter;

import java.util.ArrayList;
import java.util.List;

/**
 * @version v1.0
 * @ClassName: FilterChain
 * @Description: 责任链
 * @Author: kenshine
 */
public class FilterChain { //过滤器链

    private List<Filter> filters = new ArrayList<>();

    private int index = 0;

    // 链式调用
    public FilterChain addFilter(Filter filter) {
        this.filters.add(filter);
        return this;
    }

    public void doFilter(Request request, Response response) {
        if (index == filters.size()) {
            return;
        }
        Filter filter = filters.get(index);
        index++;
        filter.doFilter(request, response, this);
    }
}
