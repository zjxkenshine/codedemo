package com.kenshine.mx4j.test01;

public class SimpleBooks implements SimpleBooksMBean {
    private String m_name = null;

    public SimpleBooks(String bookName) {
        this.m_name = bookName;
    }

    @Override
    public void setBook(String bookName) {
        this.m_name = bookName;
    }

    @Override
    public String getBook() {
        return this.m_name;
    }
}
