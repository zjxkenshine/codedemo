package com.kenshine.demo04.test;

import com.kenshine.demo04.model.Book;
import com.kenshine.demo04.service.BookService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author ：kenshine
 * @date ：Created in 2022/1/15 22:04
 * @description：
 * @modified By：
 * @version: $
 */
public class TestBook {

    @Test
    public void testJdbcTemplate(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");
        BookService bookService = context.getBean("bookService", BookService.class);

        //添加
//        Book book = new Book();
//        book.setUserId("1");
//        book.setUsername("kenshine");
//        book.setUstatus("1");
//        bookService.addBook(book);

        //修改
        Book book = new Book();
        book.setUserId("1");
        book.setUsername("kenshine");
        book.setUstatus("1");
        bookService.updateBook(book);

        //删除
        bookService.delete("1");
    }



}
