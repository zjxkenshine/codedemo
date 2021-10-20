package com.kenshine.jdbc.dao.impl;

import com.kenshine.jdbc.dao.IUserDao;
import com.kenshine.jdbc.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author ：kenshine
 * @date ：Created in 2021/10/20 10:23
 * @description：dao层接口实现
 * @modified By：
 * @version: $
 *
 * @repository跟@Service,@Compent,@Controller这4种注解是没什么本质区别,都是声明作用,取不同的名字只是为了更好区分各自的功能
 */
@Repository
public class UserDaoImpl implements IUserDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int add(User user) {
        return jdbcTemplate.update("insert into users(username, password) values(?, ?)",
                user.getUsername(),user.getPassword());
    }

    @Override
    public int update(User user) {
        return jdbcTemplate.update("UPDATE  users SET username=? ,password=? WHERE id=?",
                user.getUsername(),user.getPassword(),user.getId());
    }

    @Override
    public int delete(int id) {
        return jdbcTemplate.update("DELETE from users where id=?",id);
    }

    @Override
    public User findUserById(int id) {
        // BeanPropertyRowMapper 使获取的 List 结果列表的数据库字段和实体类自动对应
        List<User> list = jdbcTemplate.query("select * from users where id = ?", new Object[]{id}, new BeanPropertyRowMapper(User.class));
        return list.size()>0?list.get(0):null;
    }

    @Override
    public List<User> findUserList() {
        // 使用Spring的JdbcTemplate查询数据库，获取List结果列表，数据库表字段和实体类自动对应，可以使用BeanPropertyRowMapper
        List<User> list = jdbcTemplate.query("select * from users", new Object[]{}, new BeanPropertyRowMapper(User.class));
        return list.size()>0?list:null;
    }

}
