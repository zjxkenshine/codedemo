package com.kenshine.designpattern.gof10_Filter.test01.filter;

import com.kenshine.designpattern.gof10_Filter.test01.User;

import java.util.List;

/**
 * @author ：kenshine
 * @date ：Created in 2022/2/1 19:51
 * @description：
 * @modified By：
 * @version: $
 */
public interface Filter {
    List<User> doFilter(List<User> users);
}
