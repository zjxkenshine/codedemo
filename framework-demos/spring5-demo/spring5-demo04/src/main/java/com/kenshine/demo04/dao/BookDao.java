package com.kenshine.demo04.dao;

import com.kenshine.demo04.model.Book;

;import java.util.List;

/**
 * @author ：kenshine
 * @date ：Created in 2022/1/15 21:46
 * @description：
 * @modified By：
 * @version: $
 */
public interface BookDao {
    void add(Book book);

    void updateBook(Book book);

    void delete(String id);

    int selectCount();

    Book findBookInfo(String id);

    List<Book> findAllBook();

    void batchAddBook(List<Object[]> batchArgs);

    void batchUpdateBook(List<Object[]> batchArgs);

    void batchDeleteBook(List<Object[]> batchArgs);
}
