package com.example.book_crud.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.book_crud.domain.Book;


public interface BookService extends IService<Book> {

    //追加的操作与原始操作通过名称区分，功能类似
    boolean saveBook(Book book);
    boolean modify(Book book);
    boolean delete(Integer id);

    IPage<Book> getPage(int currentPage,int pageSize);

    IPage<Book> getPage(int currentPage, int pageSize, Book book);
}
