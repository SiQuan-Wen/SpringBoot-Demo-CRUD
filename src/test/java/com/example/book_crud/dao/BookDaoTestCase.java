package com.example.book_crud.dao;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.book_crud.domain.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class BookDaoTestCase {
@Autowired
private BookDao bookDao ;
//编写测试用例
    @Test
    void testGetById(){
        System.out.println(bookDao.selectById(1));
    }
    @Test
    void testQueryAll(){
        bookDao.selectList(null);
    }
    @Test
    void testQueryByCondition(){
        String name = "1";
        LambdaQueryWrapper<Book> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.like(true,Book::getName,name);
        bookDao.selectList(lambdaQueryWrapper);
    }
    @Test
    void testSave(){
        Book book = new Book();
        book.setType("测试用例-经济");
        book.setName("测试用例-资本论");
        book.setDescription("马克思");
        bookDao.insert(book);
    }
    @Test
    void testUpdate(){
        Book book = new Book();
        book.setId(13);
        book.setType("测试用例-经济");
        book.setName("测试用例-资本论");
        book.setDescription("德国思想家卡尔·马克思");
        bookDao.updateById(book);
    }
    @Test
    void testDelete(){
        bookDao.deleteById(13);
    }
    @Test
    void testGetPage(){
    IPage<Book> page = new Page<>(1,5);
    bookDao.selectPage(page,null);
    System.out.println(page.getCurrent());
    System.out.println(page.getSize());
    System.out.println(page.getTotal());
    System.out.println(page.getPages());
    System.out.println(page.getRecords());
    }


}
