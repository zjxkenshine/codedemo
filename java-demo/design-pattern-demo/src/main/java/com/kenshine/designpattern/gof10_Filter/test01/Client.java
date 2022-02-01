package com.kenshine.designpattern.gof10_Filter.test01;

import com.kenshine.designpattern.gof10_Filter.test01.filter.AgeFilter;
import com.kenshine.designpattern.gof10_Filter.test01.filter.Filter;
import com.kenshine.designpattern.gof10_Filter.test01.filter.VipFilter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：kenshine
 * @date ：Created in 2022/2/1 19:56
 * @description：
 * @modified By：
 * @version: $
 */
public class Client {
    public static void main(String[] args) {
        List<User> users = new ArrayList<>(8);
        users.add(new User("kenshine",true,18));
        users.add(new User("qin",true,20));
        users.add(new User("bin",false,9));
        users.add(new User("saxon",false,35));
        users.add(new User("tuent",true,27));
        users.add(new User("bent",false,28));
        users.add(new User("tt",true,19));
        users.add(new User("liu",false,38));

        Filter ageFilter = new AgeFilter();
        Filter vipFilter = new VipFilter();

        System.out.println(ageFilter.doFilter(users));
        System.out.println(vipFilter.doFilter(users));
        System.out.println(vipFilter.doFilter(ageFilter.doFilter(users)));
    }
}
