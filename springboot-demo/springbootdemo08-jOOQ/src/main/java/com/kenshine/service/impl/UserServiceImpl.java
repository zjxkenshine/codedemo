package com.kenshine.service.impl;

import com.kenshine.generator.tables.User;
import com.kenshine.service.UserService;
import org.jooq.DSLContext;
import org.jooq.Record;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ：kenshine
 * @date ：Created in 2021/10/21 9:30
 * @description：用户业务实现
 * @modified By：
 * @version: $
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    DSLContext dsl;

    /**
     * 给User表 重命名 u 。（类似sql语句中的 user as u）.
     * 注意一点，这个User类是逆向生成的tables包下的，不是pojos包下的User实体类。
     * （逆向工程它会生成两个User类。一个在pojos下，一个再tables下）
     */
    com.kenshine.generator.tables.User u = User.USER.as("u");

    /**
     * 删除
     */
    @Override
    public void delete(int id) {
        dsl.delete(u).where(u.ID.eq(id));
    }

    /**
     * 增加
     */
    @Override
    public void insert(com.kenshine.generator.tables.pojos.User user) {
        dsl.insertInto(u).
                columns(u.USERNAME,u.PASSWORD).
                values(user.getUsername(),user.getPassword())
                .execute();
    }

    /**
     * 更新
     *
     * @param user
     */
    @Override
    public int update(com.kenshine.generator.tables.pojos.User user) {
        dsl.update(u).set((Record) user);
        return 0;
    }

    /**
     * 查询单个
     */
    @Override
    public com.kenshine.generator.tables.pojos.User selectById(int id) {
        List<com.kenshine.generator.tables.pojos.User> result =  dsl.select(u.ID,u.USERNAME,u.PASSWORD)
                .from(u)
                .where(u.ID.eq(id))
                .fetch()
                .into(com.kenshine.generator.tables.pojos.User.class);

        return result.get(0);
    }

    /**
     * 查询全部列表
     */
    @Override
    public List<com.kenshine.generator.tables.pojos.User> selectAll(int pageNum, int pageSize) {
        return dsl.select()
                .from(u)
                //id倒序
                .orderBy(u.ID.desc())
                //分页
                .limit(pageSize)
                //分页
                .offset(pageSize*(pageNum-1))
                .fetch()
                //数据类型格式转化
                .into(com.kenshine.generator.tables.pojos.User.class);
    }

}
