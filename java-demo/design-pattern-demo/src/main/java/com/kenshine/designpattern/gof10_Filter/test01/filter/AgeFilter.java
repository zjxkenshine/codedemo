package com.kenshine.designpattern.gof10_Filter.test01.filter;

import com.kenshine.designpattern.gof10_Filter.test01.User;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author ：kenshine
 * @date ：Created in 2022/2/1 19:59
 * @description：
 * @modified By：
 * @version: $
 */
public class AgeFilter implements Filter{
    @Override
    public List<User> doFilter(List<User> users) {
        return users.stream().filter(u->u.getAge()>25).collect(Collectors.toList());
    }
}
