package com.example.book_crud.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.book_crud.domain.Book;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BookDao extends BaseMapper<Book> {

}
