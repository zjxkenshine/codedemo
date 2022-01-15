package com.kenshine.demo04.dao.impl;

import com.kenshine.demo04.dao.BookDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.kenshine.demo04.model.Book;

import java.util.Arrays;
import java.util.List;


/**
 * @author ：kenshine
 * @date ：Created in 2022/1/15 21:47
 * @description：
 * @modified By：
 * @version: $
 */
@Repository
public class BookDaoImpl implements BookDao{
    //注入 JdbcTemplate
    @Autowired
    private JdbcTemplate jdbcTemplate;

    //添加的方法
    @Override
    public void add(Book book) {
        //1 创建 sql 语句
        String sql = "insert into t_book values(?,?,?)";
        //2 调用方法实现
        Object[] args = {book.getUserId(), book.getUsername(),book.getUstatus()};
        int update = jdbcTemplate.update(sql,args);
        System.out.println(update);
    }

    //1、修改
    @Override
    public void updateBook(Book book) {
        String sql = "update t_book set username=?,ustatus=? where user_id=?";
        Object[] args = {book.getUsername(), book.getUstatus(),book.getUserId()};
        int update = jdbcTemplate.update(sql, args);
        System.out.println(update);
    }
    //2、删除
    @Override
    public void delete(String id) {
        String sql = "delete from t_book where user_id=?";
        int update = jdbcTemplate.update(sql, id);
        System.out.println(update);
    }

    //查询表记录数
    @Override
    public int selectCount() {
        String sql = "select count(*) from t_book";
        //queryForObject方法中：第一个参数代表--sql语句；第二个参数代表--返回类型class
        Integer count = jdbcTemplate.queryForObject(sql, Integer.class);
        return count;
    }

    //查询返回对象
    @Override
    public Book findBookInfo(String id) {
        String sql = "select * from t_book where user_id=?";
        //调用方法
/*
	queryForObject方法中：
		第一个参数：sql语句
		第二个参数：RowMapper 是接口，针对返回不同类型数据，使用这个接口里面 实现类 完成数据封装
		第三个参数：sql 语句值
*/
        Book book = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<Book>(Book.class), id);
        return book;
    }

    //所用场景：查询图书列表分页、、
    //查询返回集合
    @Override
    public List<Book> findAllBook() {
        String sql = "select * from t_book";
        //调用方法
        List<Book> bookList = jdbcTemplate.query(sql, new BeanPropertyRowMapper<Book>(Book.class));
        return bookList;
    }

    //批量添加
    @Override
    public void batchAddBook(List<Object[]> batchArgs) {
        String sql = "insert into t_book values(?,?,?)";
//batchUpdate方法 第一个参数：sql语句		第二个参数：List集合，添加多条记录数据
        int[] ints = jdbcTemplate.batchUpdate(sql, batchArgs);
        System.out.println(Arrays.toString(ints));
    }

    //批量修改(同批量添加一样，调用同一个方法)
    @Override
    public void batchUpdateBook(List<Object[]> batchArgs) {
        String sql = "update t_book set username=?,ustatus=? where user_id=?";
        int[] ints = jdbcTemplate.batchUpdate(sql, batchArgs);
        System.out.println(Arrays.toString(ints));
    }

    /**
     * 批量删除
     */
    @Override
    public void batchDeleteBook(List<Object[]> batchArgs) {
        String sql = "DELETE FROM t_book WHERE user_id=?";
        int[] ints = jdbcTemplate.batchUpdate(sql, batchArgs);
        System.out.println(ints.length);
    }

}
