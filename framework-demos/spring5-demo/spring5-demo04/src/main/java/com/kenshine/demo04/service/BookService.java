package com.kenshine.demo04.service;

import com.kenshine.demo04.dao.BookDao;
import com.kenshine.demo04.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ：kenshine
 * @date ：Created in 2022/1/15 21:46
 * @description：
 * @modified By：
 * @version: $
 */
@Service
public class BookService {
    //注入 dao
    @Autowired
    private BookDao bookDao;

    public void addBook(Book book) {
        bookDao.add(book);
    }

    public void updateBook(Book book) {
        bookDao.updateBook(book);
    }

    public void delete(String id) {
        bookDao.delete(id);
    }

    //    查询行数 记录数学
    public int findConutBook() {
        return bookDao.selectCount();
    }

    // 查询一个对象
    public Book findOneBook(String id) {
        return bookDao.findBookInfo(id);
    }

    //查询所有对象
    public List<Book> findAllBook() {
        return bookDao.findAllBook();
    }

    //    批量add
    public void batchAddBook(List<Object[]> batchArgs) {
        bookDao.batchAddBook(batchArgs);
    }

    // 批量修改
    public void batchUpdateBook(List<Object[]> batchArgs) {
        bookDao.batchUpdateBook(batchArgs);
    }

    //批量删除
       public void batchDeleteBook(List<Object[]> batchArgs) {
        bookDao.batchDeleteBook(batchArgs);
    }

}
