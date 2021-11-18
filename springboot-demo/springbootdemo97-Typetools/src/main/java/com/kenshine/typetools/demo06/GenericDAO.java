package com.kenshine.typetools.demo06;

import net.jodah.typetools.TypeResolver;

import java.io.Serializable;

/**
 * @author ：kenshine
 * @date ：Created in 2021/11/18 9:12
 * @description：
 * @modified By：
 * @version: $
 */
public class GenericDAO<T, ID extends Serializable> {
    protected Class<T> persistentClass;
    protected Class<ID> idClass;

    public GenericDAO() {
        Class<?>[] typeArguments = TypeResolver.resolveRawArguments(GenericDAO.class, getClass());
        this.persistentClass = (Class<T>) typeArguments[0];
        this.idClass = (Class<ID>) typeArguments[1];
    }
}
