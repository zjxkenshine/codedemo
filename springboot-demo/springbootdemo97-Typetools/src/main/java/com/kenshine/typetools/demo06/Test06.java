package com.kenshine.typetools.demo06;

/**
 * @author ：kenshine
 * @date ：Created in 2021/11/18 9:14
 * @description：
 * @modified By：
 * @version: $
 */
public class Test06 {
    public static void main(String[] args) {
        RouterDAO routerDAO = new RouterDAO();
        //获取RouterDAO的实际类型
        assert routerDAO.persistentClass == Router.class;
        assert routerDAO.idClass == Long.class;
    }
}
