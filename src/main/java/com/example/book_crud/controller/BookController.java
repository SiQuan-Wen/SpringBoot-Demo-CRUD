package com.example.book_crud.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.book_crud.controller.utils.Result;
import com.example.book_crud.domain.Book;
import com.example.book_crud.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping
    public Result queryAll(){
        return new Result(true,bookService.list());
    }

    @PostMapping
    public Result save(@RequestBody Book book){
        return new Result(bookService.save(book));
    }

    @PutMapping
    public Result update(@RequestBody Book book){
        return new Result(bookService.modify(book));
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id){
        return new Result(bookService.delete(id));
    }

    @GetMapping("/{id}")
    public Result getById(@PathVariable Integer id){
        return new Result(true,bookService.getById(id));
    }

    @GetMapping("{currentPage}/{pageSize}")
    public Result getPage(@PathVariable int currentPage,@PathVariable int pageSize,Book book){
        IPage<Book> page = bookService.getPage(currentPage, pageSize,book);
        //如果当前页码值大于总页码数，那么重新执行查询操作，使用最大页码值作为当前页码值。
        if (currentPage > page.getPages()){
            page = bookService.getPage((int)page.getPages(),pageSize);
        }
        return new Result(true,bookService.getPage(currentPage,pageSize,book));
    }

}