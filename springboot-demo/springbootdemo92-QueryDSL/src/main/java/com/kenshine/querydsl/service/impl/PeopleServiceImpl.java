package com.kenshine.querydsl.service.impl;

import com.kenshine.querydsl.entity.People;
import com.kenshine.querydsl.entity.QPeople;
import com.kenshine.querydsl.service.PeopleService;
import com.querydsl.core.types.EntityPath;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author ：kenshine
 * @date ：Created in 2021/11/16 23:21
 * @description：实现类
 * @modified By：
 * @version: $
 */
@Service
public class PeopleServiceImpl implements PeopleService {
    @Resource
    JPAQueryFactory queryFactory;

    @Override
    public People selectOne(Integer id) {
        /**
         * QPeople在maven打包后生成
         */
        QPeople people = QPeople.people;
        return queryFactory.selectFrom(people).where(people.id.eq(id)).fetchOne();
    }
}
