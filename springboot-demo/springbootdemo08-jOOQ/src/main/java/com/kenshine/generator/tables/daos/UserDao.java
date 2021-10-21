/*
 * This file is generated by jOOQ.
 */
package com.kenshine.generator.tables.daos;


import com.kenshine.generator.tables.User;
import com.kenshine.generator.tables.records.UserRecord;

import java.util.List;

import org.jooq.Configuration;
import org.jooq.impl.DAOImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class UserDao extends DAOImpl<UserRecord, com.kenshine.generator.tables.pojos.User, Integer> {

    /**
     * Create a new UserDao without any configuration
     */
    public UserDao() {
        super(User.USER, com.kenshine.generator.tables.pojos.User.class);
    }

    /**
     * Create a new UserDao with an attached configuration
     */
    public UserDao(Configuration configuration) {
        super(User.USER, com.kenshine.generator.tables.pojos.User.class, configuration);
    }

    @Override
    public Integer getId(com.kenshine.generator.tables.pojos.User object) {
        return object.getId();
    }

    /**
     * Fetch records that have <code>id BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<com.kenshine.generator.tables.pojos.User> fetchRangeOfId(Integer lowerInclusive, Integer upperInclusive) {
        return fetchRange(User.USER.ID, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>id IN (values)</code>
     */
    public List<com.kenshine.generator.tables.pojos.User> fetchById(Integer... values) {
        return fetch(User.USER.ID, values);
    }

    /**
     * Fetch a unique record that has <code>id = value</code>
     */
    public com.kenshine.generator.tables.pojos.User fetchOneById(Integer value) {
        return fetchOne(User.USER.ID, value);
    }

    /**
     * Fetch records that have <code>password BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<com.kenshine.generator.tables.pojos.User> fetchRangeOfPassword(String lowerInclusive, String upperInclusive) {
        return fetchRange(User.USER.PASSWORD, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>password IN (values)</code>
     */
    public List<com.kenshine.generator.tables.pojos.User> fetchByPassword(String... values) {
        return fetch(User.USER.PASSWORD, values);
    }

    /**
     * Fetch records that have <code>username BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<com.kenshine.generator.tables.pojos.User> fetchRangeOfUsername(String lowerInclusive, String upperInclusive) {
        return fetchRange(User.USER.USERNAME, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>username IN (values)</code>
     */
    public List<com.kenshine.generator.tables.pojos.User> fetchByUsername(String... values) {
        return fetch(User.USER.USERNAME, values);
    }
}